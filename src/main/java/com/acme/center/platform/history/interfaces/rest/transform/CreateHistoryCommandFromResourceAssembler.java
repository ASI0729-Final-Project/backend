package com.acme.center.platform.history.interfaces.rest.transform;

import com.acme.center.platform.history.domain.model.commands.CreateHistoryCommand;
import com.acme.center.platform.history.interfaces.rest.resources.CreateHistoryResource;

public class CreateHistoryCommandFromResourceAssembler {

    public static CreateHistoryCommand toCommandFromResource(CreateHistoryResource resource) {
        return new CreateHistoryCommand(
                resource.getDriver(),
                resource.getFrom(),
                resource.getTo(),
                resource.getDate(),
                resource.getHour(),
                resource.getPay(),
                resource.getState(),
                resource.getRouteId()
        );
    }
}
