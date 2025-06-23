package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import dev.chhaya.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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

        List<Customer> customers = customerRepository.findAll();

        return customers
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }

}
