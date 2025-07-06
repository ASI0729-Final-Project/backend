package com.acme.center.platform.history.infrastructure.persistence.jpa.repositories;

import com.acme.center.platform.history.domain.model.aggregates.History;
import com.acme.center.platform.history.domain.model.valueobjects.TripDate;
import com.acme.center.platform.history.domain.model.valueobjects.TripState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findByDate(TripDate date);

    List<History> findByState(TripState state);
}
