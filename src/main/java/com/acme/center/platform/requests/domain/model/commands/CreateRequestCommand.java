package com.acme.center.platform.requests.domain.model.commands;

import com.acme.center.platform.requests.domain.model.valueobjects.Status;

public record CreateRequestCommand(
        String type,
        Status status,
        String trip,
        String passenger,
        String message,
        String sentDate,
        boolean viewComments,
        int requestCount
) {}
