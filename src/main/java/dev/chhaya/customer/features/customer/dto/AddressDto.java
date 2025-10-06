package dev.chhaya.customer.features.customer.dto;

public record AddressDto(
        String line1,
        String city,
        String country,
        String zip
) {
}
