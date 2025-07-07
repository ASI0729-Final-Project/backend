package com.acme.center.platform.requests.domain.services;

import com.acme.center.platform.requests.domain.model.aggregates.Request;
import com.acme.center.platform.requests.domain.model.queries.GetAllRequestsQuery;
import com.acme.center.platform.requests.domain.model.queries.GetRequestByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RequestQueryService {
    Optional<Request> handle(GetRequestByIdQuery query);
    List<Request> handle(GetAllRequestsQuery query);
}
