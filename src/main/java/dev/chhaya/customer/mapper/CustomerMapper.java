package dev.chhaya.customer.mapper;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import dev.chhaya.customer.features.customer.dto.CustomerSyncDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "dateOfBirth", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    @Mapping(target = "contacts", ignore = true)
    @Mapping(target = "kyc", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
    void toCustomerPartially(CustomerSyncDto dto,
                             @MappingTarget Customer domain);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "dateOfBirth", ignore = true)
    Customer toCustomer(CustomerSyncDto  customerSyncDto);

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
