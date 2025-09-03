package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import dev.chhaya.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service(value = "customerServiceImpl")
@RequiredArgsConstructor
public class CustomerServiceImpl implements
        CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {

        Customer customer = customerMapper.toCustomer(createCustomerRequest);
        customer.setCustomerNumber(UUID.randomUUID().toString());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        // Insert into database
        customer = customerRepository.save(customer);

        return customerMapper.fromCustomer(customer);
    }

    @Override
    public List<CustomerResponse> getCustomers() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdAt");
        List<Customer> customers = customerRepository.findAll(sort);

        return customers
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }

    @Override
    public CustomerResponse getCustomerByNo(String customerNo) {
        Customer customer = customerRepository
                .findByCustomerNumber(customerNo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return customerMapper.fromCustomer(customer);
    }

    @Override
    public void deleteCustomerByNo(String customerNo) {
        Customer customer = customerRepository
                .findByCustomerNumber(customerNo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerResponse updateCustomerByNo(String customerNo, CreateCustomerRequest createCustomerRequest) {

        Customer customer = customerRepository
                .findByCustomerNumber(customerNo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        customerMapper.toCustomerPartially(createCustomerRequest, customer);
        customer.setUpdatedAt(LocalDateTime.now());

        customer = customerRepository.save(customer);

        return customerMapper.fromCustomer(customer);
    }
}
