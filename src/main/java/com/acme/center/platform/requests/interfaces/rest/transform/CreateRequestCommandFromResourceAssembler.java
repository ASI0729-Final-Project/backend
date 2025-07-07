package com.acme.center.platform.requests.interfaces.rest.transform;

import com.acme.center.platform.requests.domain.model.commands.CreateRequestCommand;
import com.acme.center.platform.requests.interfaces.rest.resources.CreateRequestResource;

public class CreateRequestCommandFromResourceAssembler {
    public static CreateRequestCommand toCommandFromResource(CreateRequestResource resource) {
        return new CreateRequestCommand(
                resource.type(),
                resource.status(),
                resource.trip(),
                resource.passenger(),
                resource.message(),
                resource.sentDate(),
                resource.viewComments(),
                resource.requestCount()
        );
    }
}
