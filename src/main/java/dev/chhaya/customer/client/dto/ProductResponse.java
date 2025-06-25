package dev.chhaya.customer.client.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponse(
        Integer id,
        String title,
        String slug,
        BigDecimal price,
        String description,
        CategoryResponse category,
        List<String> images
) {
}
