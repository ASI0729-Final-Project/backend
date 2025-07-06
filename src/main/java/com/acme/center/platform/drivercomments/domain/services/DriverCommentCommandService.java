package com.acme.center.platform.drivercomments.domain.services;

import com.acme.center.platform.drivercomments.domain.model.aggregates.DriverComment;
import com.acme.center.platform.drivercomments.domain.model.commands.CreateDriverCommentCommand;

import java.util.Optional;

public interface DriverCommentCommandService {
    Optional<DriverComment> handle(CreateDriverCommentCommand command);
}
