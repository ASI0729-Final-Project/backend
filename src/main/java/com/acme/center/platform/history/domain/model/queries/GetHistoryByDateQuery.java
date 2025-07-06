package com.acme.center.platform.history.domain.model.queries;

import com.acme.center.platform.history.domain.model.valueobjects.TripDate;

public record GetHistoryByDateQuery(TripDate date) {
    public GetHistoryByDateQuery(String date) {
        this(new TripDate(date));
    }
}
