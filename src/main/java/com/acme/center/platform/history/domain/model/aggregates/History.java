//*
package com.acme.center.platform.history.domain.model.aggregates;

import com.acme.center.platform.history.domain.model.commands.CreateHistoryCommand;
import com.acme.center.platform.history.domain.model.valueobjects.*;
import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class History extends AuditableAbstractAggregateRoot<History> {

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "driver"))
    private Driver driver;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "from_location"))
    private Location from;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "to_location"))
    private Location to;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "date"))
    private TripDate date;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "hour"))
    private TripTime hour;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "pay"))
    private Payment pay;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "state"))
    private TripState state;

    @Column(nullable = false)
    private Long routeId;

    public History(CreateHistoryCommand command) {
        this.driver = new Driver(command.driver());
        this.from = new Location(command.from());
        this.to = new Location(command.to());
        this.date = new TripDate(command.date());
        this.hour = new TripTime(command.hour());
        this.pay = new Payment(command.pay());
        this.state = new TripState(command.state());
        this.routeId = command.routeId();
    }
}

