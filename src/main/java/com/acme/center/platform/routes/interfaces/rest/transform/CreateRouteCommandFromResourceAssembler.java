package com.acme.center.platform.routes.interfaces.rest.transform;

import com.acme.center.platform.routes.domain.model.commands.CreateRouteCommand;
import com.acme.center.platform.routes.interfaces.rest.resources.CreateRouteResource;

public class CreateRouteCommandFromResourceAssembler {
    public static CreateRouteCommand toCommandFromResource(CreateRouteResource resource) {
        return new CreateRouteCommand(
                resource.origin(),
                resource.destination(),
                resource.date(),
                resource.time(),
                resource.price(),
                resource.seats(),
                resource.quoteId()
        );
    }
}
