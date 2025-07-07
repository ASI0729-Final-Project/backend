package com.acme.center.platform.requests.domain.services;

import com.acme.center.platform.requests.domain.model.aggregates.Request;
import com.acme.center.platform.requests.domain.model.commands.CreateRequestCommand;

import java.util.Optional;

public interface RequestCommandService {
    Optional<Request> handle(CreateRequestCommand command);
}
