package dev.chhaya.customer.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {

    // Convert Debezium epochMicroseconds to LocalDateTime
    public static LocalDateTime toLocalDateTime(long epochMicros) {
        long seconds = epochMicros / 1_000_000;
        long nanos = (epochMicros % 1_000_000) * 1000;

        return LocalDateTime.ofInstant(
                Instant.ofEpochSecond(seconds, nanos),
                ZoneId.of("UTC")
        );
    }

    // Convert Debezium epochMilliseconds to LocalDate
    public static LocalDate toLocalDate(long epochMillis) {
        return LocalDateTime
                .ofInstant(Instant.ofEpochMilli(epochMillis), ZoneId.of("UTC"))
                .toLocalDate();
    }
}

