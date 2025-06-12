package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceV2Impl implements CustomerService{

    @Override
    public List<CustomerResponse> getCustomers() {
        return List.of();
    }

}
