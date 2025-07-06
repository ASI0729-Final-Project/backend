package com.acme.center.platform.drivercomments.domain.model.aggregates;

import com.acme.center.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.acme.center.platform.drivercomments.domain.model.commands.CreateDriverCommentCommand;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class DriverComment extends AuditableAbstractAggregateRoot<DriverComment> {
    private Long driverId;
    private String comment;
    private Integer rating;

    public DriverComment() {}

    public DriverComment(Long driverId, String comment, Integer rating) {
        this.driverId = driverId;
        this.comment = comment;
        this.rating = rating;
    }

    public DriverComment(CreateDriverCommentCommand command) {
        this.driverId = command.driverId();
        this.comment = command.comment();
        this.rating = command.rating();
    }

    public Long getDriverId() {
        return driverId;
    }

    public String getComment() {
        return comment;
    }

    public Integer getRating() {
        return rating;
    }
}
