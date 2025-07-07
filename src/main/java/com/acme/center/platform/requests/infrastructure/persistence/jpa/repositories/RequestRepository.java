package com.acme.center.platform.requests.infrastructure.persistence.jpa.repositories;

import com.acme.center.platform.requests.domain.model.aggregates.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}
