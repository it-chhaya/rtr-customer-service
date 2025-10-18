package dev.chhaya.customer.mapper;

import dev.chhaya.customer.domain.Address;
import dev.chhaya.customer.features.customer.dto.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "customerId", target = "customer.id")
    Address fromAddressDto(Long customerId, AddressDto addressDto);

}
