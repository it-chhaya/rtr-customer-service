package dev.chhaya.customer;

import lombok.Builder;

@Builder
public record CustomerResponse(
        String customerId,
        String firstName,
        String lastName,
        String kyc
) {
}
