package com.acme.center.platform.drivercomments.interfaces.rest.transform;

import com.acme.center.platform.drivercomments.domain.model.commands.CreateDriverCommentCommand;
import com.acme.center.platform.drivercomments.interfaces.rest.resources.CreateDriverCommentResource;

public class CreateDriverCommentCommandFromResourceAssembler {
    public static CreateDriverCommentCommand toCommandFromResource(CreateDriverCommentResource resource) {
        return new CreateDriverCommentCommand(resource.driverId(), resource.comment(), resource.rating());
    }
}
