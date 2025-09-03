package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);

    List<CustomerResponse> getCustomers();

    CustomerResponse getCustomerByNo(String customerNo);

}
