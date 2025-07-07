package com.acme.center.platform.requests.interfaces.rest.resources;

import com.acme.center.platform.requests.domain.model.valueobjects.Status;

public record CreateRequestResource(
        String type,
        Status status,
        String trip,
        String passenger,
        String message,
        String sentDate,
        boolean viewComments,
        int requestCount
) {
    public CreateRequestResource {
        if (type == null || type.isBlank()) throw new IllegalArgumentException("Type is required");
        if (trip == null || trip.isBlank()) throw new IllegalArgumentException("Trip is required");
        if (passenger == null || passenger.isBlank()) throw new IllegalArgumentException("Passenger is required");
        if (message == null || message.isBlank()) throw new IllegalArgumentException("Message is required");
        if (sentDate == null || sentDate.isBlank()) throw new IllegalArgumentException("Sent date is required");
    }
}
