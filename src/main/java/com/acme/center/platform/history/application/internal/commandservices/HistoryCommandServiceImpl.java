package com.acme.center.platform.history.application.internal.commandservices;

import com.acme.center.platform.history.domain.model.aggregates.History;
import com.acme.center.platform.history.domain.model.commands.CreateHistoryCommand;
import com.acme.center.platform.history.domain.services.HistoryCommandService;
import com.acme.center.platform.history.infrastructure.persistence.jpa.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HistoryCommandServiceImpl implements HistoryCommandService {

    private final HistoryRepository historyRepository;

    public HistoryCommandServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public Optional<History> handle(CreateHistoryCommand command) {
        var history = new History(command);
        return Optional.of(historyRepository.save(history));
    }
}
