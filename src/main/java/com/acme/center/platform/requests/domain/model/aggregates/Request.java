package com.acme.center.platform.requests.domain.model.aggregates;

import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.acme.center.platform.requests.domain.model.commands.CreateRequestCommand;
import com.acme.center.platform.requests.domain.model.valueobjects.Status;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Request extends AuditableAbstractAggregateRoot<Request> {

    @Getter
    private String type;

    @Getter
    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    private String trip;

    @Getter
    private String passenger;

    @Getter
    private String message;

    @Getter
    private String sentDate;

    @Getter
    private boolean viewComments;

    @Getter
    private int requestCount;

    public Request() {}

    public Request(String type, Status status, String trip, String passenger, String message, String sentDate, boolean viewComments, int requestCount) {
        this.type = type;
        this.status = status;
        this.trip = trip;
        this.passenger = passenger;
        this.message = message;
        this.sentDate = sentDate;
        this.viewComments = viewComments;
        this.requestCount = requestCount;
    }

    public Request(CreateRequestCommand command) {
        this.type = command.type();
        this.status = command.status();
        this.trip = command.trip();
        this.passenger = command.passenger();
        this.message = command.message();
        this.sentDate = command.sentDate();
        this.viewComments = command.viewComments();
        this.requestCount = command.requestCount();
    }
}
