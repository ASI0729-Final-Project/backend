package com.acme.center.platform.history.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Payment {
    private Double value;

    protected Payment() {}

    public Payment(Double value) {
        if (value == null || value < 0) {
            throw new IllegalArgumentException("Payment must be non-negative");
        }
        this.value = value;
    }

    public Double value() {
        return value;
    }
}
