package dev.chhaya.customer.features.customer.dto;

import lombok.Builder;

@Builder
public record CustomerResponse(
        String customerNo,
        String firstName,
        String lastName,
        String email,
        String segment
) {
}
