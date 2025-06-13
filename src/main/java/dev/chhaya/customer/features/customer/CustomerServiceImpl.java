package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
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

    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {

        Customer customer = new Customer();
        customer.setCustomerNumber(UUID.randomUUID().toString());
        customer.setFirstName(createCustomerRequest.firstName());
        customer.setLastName(createCustomerRequest.lastName());
        customer.setEmail(createCustomerRequest.email());
        customer.setPhoneNumber(createCustomerRequest.phoneNumber());
        customer.setDateOfBirth(createCustomerRequest.dateOfBirth());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        // Insert into database
        customer = customerRepository.save(customer);

        return CustomerResponse
                .builder()
                .customerNumber(customer.getCustomerNumber())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }

    @Override
    public List<CustomerResponse> getCustomers() {

        List<Customer> customers = customerRepository.findAll();

        return customers
                .stream()
                .map(customer -> CustomerResponse
                        .builder()
                        .customerNumber(customer.getCustomerNumber())
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .email(customer.getEmail())
                        .build())
                .toList();
    }

}
