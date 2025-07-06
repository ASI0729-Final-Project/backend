package com.acme.center.platform.history.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class TripTime {
    private String value;

    protected TripTime() {}

    public TripTime(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Time cannot be blank");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
