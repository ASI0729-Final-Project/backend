package com.acme.center.platform.routes.application.internal.queryservices;

import com.acme.center.platform.routes.domain.model.aggregates.Route;
import com.acme.center.platform.routes.domain.model.queries.GetAllRoutesQuery;
import com.acme.center.platform.routes.domain.services.RouteQueryService;
import com.acme.center.platform.routes.infrastructure.persistence.jpa.repositories.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteQueryServiceImpl implements RouteQueryService {
    private final RouteRepository routeRepository;

    public RouteQueryServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> handle(GetAllRoutesQuery query) {
        return routeRepository.findAll();
    }
}
