package dev.chhaya.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @GetMapping("/public")
    public CustomerResponse getCustomerPublic() {
        return CustomerResponse
                .builder()
                .customerId("CUS-001")
                .firstName("Chhaya")
                .lastName("Chan")
                .kyc("ACCEPTED")
                .build();
    }

    @GetMapping("/private")
    public CustomerResponse getCustomerPrivate() {
        return CustomerResponse
                .builder()
                .customerId("CUS-002")
                .firstName("Kanha")
                .lastName("Chan")
                .kyc("REJECTED")
                .build();
    }

}
