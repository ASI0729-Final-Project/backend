package com.acme.center.platform.quotes.interfaces.rest.resources;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record QuoteResource(
        Long id,
        String origin,
        String destination,
        String driver,
        String driverImage,
        BigDecimal price,
        LocalDate date,
        LocalTime time,
        int seats,
        String licensePlate,
        String carBrand,
        String image) {
}
