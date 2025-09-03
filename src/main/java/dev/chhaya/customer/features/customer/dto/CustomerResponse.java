package dev.chhaya.customer.features.customer.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CustomerResponse(
        String customerNo,
        String firstName,
        String lastName,
        String email,
        LocalDate dateOfBirth,
        String phoneNumber,
        String segment
) {
}
