package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerServiceImpl;

    @GetMapping("/public")
    public List<CustomerResponse> getCustomerPublic() {
        return customerServiceImpl.getCustomers();
    }

    @GetMapping("/private")
    public CustomerResponse getCustomerPrivate() {
        return null;
    }

}
