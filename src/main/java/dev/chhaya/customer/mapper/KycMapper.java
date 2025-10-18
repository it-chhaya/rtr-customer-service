package dev.chhaya.customer.mapper;

import dev.chhaya.customer.domain.Address;
import dev.chhaya.customer.domain.Kyc;
import dev.chhaya.customer.features.customer.dto.AddressDto;
import dev.chhaya.customer.features.customer.dto.KycDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KycMapper {

    @Mapping(source = "customerId", target = "customer.id")
    Kyc fromKycDto(Long customerId, KycDto kycDto);

}
