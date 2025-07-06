package com.acme.center.platform.drivercomments.interfaces.rest.transform;

import com.acme.center.platform.drivercomments.domain.model.aggregates.DriverComment;
import com.acme.center.platform.drivercomments.interfaces.rest.resources.DriverCommentResource;

public class DriverCommentResourceFromEntityAssembler {
    public static DriverCommentResource toResourceFromEntity(DriverComment entity) {
        return new DriverCommentResource(
                entity.getId(),
                entity.getDriverId(),
                entity.getComment(),
                entity.getRating());
    }
}
