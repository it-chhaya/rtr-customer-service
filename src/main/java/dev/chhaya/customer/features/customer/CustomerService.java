package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.features.customer.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> getCustomers();

    //List<CustomerResponse> getCustomersByProvider(String providerId);

}
