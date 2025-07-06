package com.acme.center.platform.history.application.internal.queryservices;

import com.acme.center.platform.history.domain.model.aggregates.History;
import com.acme.center.platform.history.domain.model.queries.*;
import com.acme.center.platform.history.domain.services.HistoryQueryService;
import com.acme.center.platform.history.infrastructure.persistence.jpa.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryQueryServiceImpl implements HistoryQueryService {


    private final HistoryRepository historyRepository;

    public HistoryQueryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> handle(GetAllHistoryQuery query) {
        return historyRepository.findAll();
    }

    @Override
    public List<History> handle(GetHistoryByDateQuery query) {
        return historyRepository.findByDate(query.date());
    }

    @Override
    public List<History> handle(GetHistoryByStateQuery query) {
        return historyRepository.findByState(query.state());
    }
}
