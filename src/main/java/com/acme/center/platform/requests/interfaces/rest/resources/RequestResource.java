package com.acme.center.platform.requests.interfaces.rest.resources;

public record RequestResource(
        Long id,
        String type,
        String status,
        String trip,
        String passenger,
        String message,
        String sentDate,
        boolean viewComments,
        int requestCount
) {}
