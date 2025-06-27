package dev.chhaya.customer.exception;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Builder
public record RestError(
        String title,
        String description,
        Integer statusCode,
        LocalDateTime timestamp,
        List<Map<String, String>> fieldErrors
) {
}
