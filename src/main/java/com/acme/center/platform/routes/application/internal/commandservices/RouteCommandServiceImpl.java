package com.acme.center.platform.routes.application.internal.commandservices;

import com.acme.center.platform.routes.domain.model.aggregates.Route;
import com.acme.center.platform.routes.domain.model.commands.CreateRouteCommand;
import com.acme.center.platform.routes.domain.services.RouteCommandService;
import com.acme.center.platform.routes.infrastructure.persistence.jpa.repositories.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteCommandServiceImpl implements RouteCommandService {
    private final RouteRepository routeRepository;

    public RouteCommandServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Optional<Route> handle(CreateRouteCommand command) {
        var route = new Route(command);
        return Optional.of(routeRepository.save(route));
    }
}
