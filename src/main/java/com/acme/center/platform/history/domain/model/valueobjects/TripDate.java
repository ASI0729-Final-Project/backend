package com.acme.center.platform.history.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class TripDate {
    private String value;

    protected TripDate() {}

    public TripDate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Date cannot be blank");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
