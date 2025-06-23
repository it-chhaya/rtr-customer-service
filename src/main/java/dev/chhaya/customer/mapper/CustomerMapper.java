package dev.chhaya.customer.mapper;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    // Mapping logic
    // DTOs to Domain Models
    // Domain Models to DTOs
    Customer toCustomer(CreateCustomerRequest dto);

    @Mapping(source = "customerNumber", target = "customerNo")
    CustomerResponse fromCustomer(Customer customer);

}
