package com.acme.center.platform.history.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Driver {
    private String value;

    protected Driver() {}

    public Driver(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Driver name cannot be blank");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }
}
