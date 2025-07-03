package com.acme.center.platform.routes.interfaces.rest.transform;

import com.acme.center.platform.routes.domain.model.aggregates.Route;
import com.acme.center.platform.routes.interfaces.rest.resources.RouteResource;

public class RouteResourceFromEntityAssembler {
    public static RouteResource toResourceFromEntity(Route route) {
        return new RouteResource(
                route.getId(),
                route.getOrigin(),
                route.getDestination(),
                route.getDate(),
                route.getTime(),
                route.getPrice(),
                route.getSeats(),
                route.getQuoteId()
        );
    }
}
