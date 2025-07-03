package com.acme.center.platform.routes.domain.model.commands;

public record CreateRouteCommand(
        String origin,
        String destination,
        String date,
        String time,
        Double price,
        Integer seats,
        Long quoteId
) {}
