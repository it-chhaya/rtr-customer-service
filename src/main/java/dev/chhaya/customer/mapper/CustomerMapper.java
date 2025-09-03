package dev.chhaya.customer.mapper;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    // Mapping logic
    // DTOs to Domain Models
    // Domain Models to DTOs
    Customer toCustomer(CreateCustomerRequest dto);

    @Mapping(source = "customerNumber", target = "customerNo")
    @Mapping(source = "customerSegment.name", target = "segment")
    CustomerResponse fromCustomer(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    void toCustomerPartially(CreateCustomerRequest dto,
                             @MappingTarget Customer domain);

}
