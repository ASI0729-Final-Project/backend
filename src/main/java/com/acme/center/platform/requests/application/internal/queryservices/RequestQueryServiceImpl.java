package com.acme.center.platform.requests.application.internal.queryservices;

import com.acme.center.platform.requests.domain.model.aggregates.Request;
import com.acme.center.platform.requests.domain.model.queries.GetAllRequestsQuery;
import com.acme.center.platform.requests.domain.model.queries.GetRequestByIdQuery;
import com.acme.center.platform.requests.domain.services.RequestQueryService;
import com.acme.center.platform.requests.infrastructure.persistence.jpa.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestQueryServiceImpl implements RequestQueryService {

    private final RequestRepository requestRepository;

    public RequestQueryServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Optional<Request> handle(GetRequestByIdQuery query) {
        return requestRepository.findById(query.requestId());
    }

    @Override
    public List<Request> handle(GetAllRequestsQuery query) {
        return requestRepository.findAll();
    }
}
