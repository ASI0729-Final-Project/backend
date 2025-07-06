package com.acme.center.platform.history.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class TripState {
    private String value;

    protected TripState() {}

    public TripState(String value) {
        if (!value.equalsIgnoreCase("Pending") && !value.equalsIgnoreCase("Confirmed")) {
            throw new IllegalArgumentException("Trip state must be 'Pending' or 'Confirmed'");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
