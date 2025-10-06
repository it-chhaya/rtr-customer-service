package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import dev.chhaya.customer.features.customer.dto.CustomerSyncDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerServiceImpl;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sync")
    public void syncCustomer(@RequestBody CustomerSyncDto customerSyncDto) {
        customerServiceImpl.syncCustomer(customerSyncDto);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CustomerResponse createCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {
        return customerServiceImpl.createCustomer(createCustomerRequest);
    }


    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return customerServiceImpl.getCustomers();
    }


    @GetMapping("/{customerNo}")
    public CustomerResponse getCustomerByNo(@PathVariable String customerNo) {
        return customerServiceImpl.getCustomerByNo(customerNo);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{customerNo}")
    public void deleteCustomerByNo(@PathVariable String customerNo) {
        customerServiceImpl.deleteCustomerByNo(customerNo);
    }


    @PutMapping("/{customerNo}")
    public CustomerResponse updateCustomerByNo(@PathVariable String customerNo,
                                               @RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerServiceImpl.updateCustomerByNo(customerNo, createCustomerRequest);
    }
}
