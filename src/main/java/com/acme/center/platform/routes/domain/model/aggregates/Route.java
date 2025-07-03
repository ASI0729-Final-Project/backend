package com.acme.center.platform.routes.domain.model.aggregates;

import com.acme.center.platform.routes.domain.model.commands.CreateRouteCommand;
import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * Route Aggregate Root
 */
@Getter
@Entity
public class Route extends AuditableAbstractAggregateRoot<Route> {
    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String date; // yyyy-MM-dd

    @Column(nullable = false)
    private String time; // HH:mm:ss

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer seats;

    @Column(nullable = false)
    private Long quoteId; // FK connection to Quote

    public Route() {}

    public Route(String origin, String destination, String date, String time, Double price, Integer seats, Long quoteId) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seats = seats;
        this.quoteId = quoteId;
    }

    public Route(CreateRouteCommand command) {
        this.origin = command.origin();
        this.destination = command.destination();
        this.date = command.date();
        this.time = command.time();
        this.price = command.price();
        this.seats = command.seats();
        this.quoteId = command.quoteId();
    }
}
