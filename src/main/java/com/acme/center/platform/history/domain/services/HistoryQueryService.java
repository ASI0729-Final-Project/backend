package com.acme.center.platform.history.domain.services;

import com.acme.center.platform.history.domain.model.aggregates.History;
import com.acme.center.platform.history.domain.model.queries.*;

import java.util.List;

public interface HistoryQueryService {
    List<History> handle(GetAllHistoryQuery query);
    List<History> handle(GetHistoryByDateQuery query);
    List<History> handle(GetHistoryByStateQuery query);
}
