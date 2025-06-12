package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerServiceImpl")
@RequiredArgsConstructor
public class CustomerServiceImpl implements
        CustomerService {

    private final CustomerRepository customerRepository;

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
