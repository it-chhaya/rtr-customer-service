package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import dev.chhaya.customer.features.customer.dto.CustomerSyncDto;

import java.util.List;

public interface CustomerService {

    void syncUpdateCustomer(CustomerSyncDto customerSyncDto);

    void deletedById(Long id);

    void syncCustomer(CustomerSyncDto customerSyncDto);

    CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);

    List<CustomerResponse> getCustomers();

    CustomerResponse getCustomerByNo(String customerNo);

    void deleteCustomerByNo(String customerNo);

    CustomerResponse updateCustomerByNo(String customerNo, CreateCustomerRequest createCustomerRequest);

}
