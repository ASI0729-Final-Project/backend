package com.acme.center.platform.routes.domain.services;

import com.acme.center.platform.routes.domain.model.aggregates.Route;
import com.acme.center.platform.routes.domain.model.commands.CreateRouteCommand;

import java.util.Optional;

public interface RouteCommandService {
    Optional<Route> handle(CreateRouteCommand command);
}
