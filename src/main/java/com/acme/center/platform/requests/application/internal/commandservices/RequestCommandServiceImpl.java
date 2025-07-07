package com.acme.center.platform.requests.application.internal.commandservices;

import com.acme.center.platform.requests.domain.model.aggregates.Request;
import com.acme.center.platform.requests.domain.model.commands.CreateRequestCommand;
import com.acme.center.platform.requests.domain.services.RequestCommandService;
import com.acme.center.platform.requests.infrastructure.persistence.jpa.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequestCommandServiceImpl implements RequestCommandService {

    private final RequestRepository requestRepository;

    public RequestCommandServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Optional<Request> handle(CreateRequestCommand command) {
        var request = new Request(command);
        return Optional.of(requestRepository.save(request));
    }
}
