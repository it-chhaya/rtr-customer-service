package dev.chhaya.customer.mapper;

import dev.chhaya.customer.domain.Address;
import dev.chhaya.customer.domain.Contact;
import dev.chhaya.customer.features.customer.dto.AddressDto;
import dev.chhaya.customer.features.customer.dto.ContactDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mapping(source = "customerId", target = "customer.id")
    Contact fromContactDto(Long customerId, ContactDto contactDto);

}
