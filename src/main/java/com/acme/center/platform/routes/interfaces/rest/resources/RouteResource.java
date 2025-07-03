package com.acme.center.platform.routes.interfaces.rest.resources;

public record RouteResource(
        Long id,
        String origin,
        String destination,
        String date,
        String time,
        Double price,
        Integer seats,
        Long quoteId
) {}
