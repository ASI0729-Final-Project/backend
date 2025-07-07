package com.acme.center.platform.requests.interfaces.rest.transform;

import com.acme.center.platform.requests.domain.model.aggregates.Request;
import com.acme.center.platform.requests.interfaces.rest.resources.RequestResource;

public class RequestResourceFromEntityAssembler {
    public static RequestResource toResourceFromEntity(Request entity) {
        return new RequestResource(
                entity.getId(),
                entity.getType(),
                entity.getStatus().name(),
                entity.getTrip(),
                entity.getPassenger(),
                entity.getMessage(),
                entity.getSentDate(),
                entity.isViewComments(),
                entity.getRequestCount()
        );
    }
}
