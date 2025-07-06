package com.acme.center.platform.history.domain.model.queries;

import com.acme.center.platform.history.domain.model.valueobjects.TripState;

public record GetHistoryByStateQuery(TripState state) {
    public GetHistoryByStateQuery(String state) {
        this(new TripState(state));
    }
}
