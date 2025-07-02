package com.acme.center.platform.quotes.domain.model.commands;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record CreateQuoteCommand(
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
