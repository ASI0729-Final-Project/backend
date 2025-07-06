package com.acme.center.platform.history.interfaces.rest.transform;

import com.acme.center.platform.history.domain.model.aggregates.History;
import com.acme.center.platform.history.interfaces.rest.resources.HistoryResource;

public class HistoryResourceFromEntityAssembler {

    public static HistoryResource toResourceFromEntity(History history) {
        return HistoryResource.builder()
                .id(history.getId())
                .driver(history.getDriver().value())
                .from(history.getFrom().value())
                .to(history.getTo().value())
                .date(history.getDate().value())
                .hour(history.getHour().value())
                .pay(history.getPay().value())
                .state(history.getState().value())
                .routeId(history.getRouteId())
                .build();
    }
}
