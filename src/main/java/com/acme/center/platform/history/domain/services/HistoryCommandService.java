package com.acme.center.platform.history.domain.services;

import com.acme.center.platform.history.domain.model.aggregates.History;
import com.acme.center.platform.history.domain.model.commands.CreateHistoryCommand;

import java.util.Optional;

public interface HistoryCommandService {
    Optional<History> handle(CreateHistoryCommand command);
}
