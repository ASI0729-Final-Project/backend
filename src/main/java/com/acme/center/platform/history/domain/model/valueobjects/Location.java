package com.acme.center.platform.history.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Location {
    private String value;

    protected Location() {}

    public Location(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Location cannot be blank");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
