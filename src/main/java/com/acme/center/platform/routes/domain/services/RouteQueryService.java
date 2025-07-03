package com.acme.center.platform.routes.domain.services;

import com.acme.center.platform.routes.domain.model.aggregates.Route;
import com.acme.center.platform.routes.domain.model.queries.GetAllRoutesQuery;

import java.util.List;

public interface RouteQueryService {
    List<Route> handle(GetAllRoutesQuery query);
}
