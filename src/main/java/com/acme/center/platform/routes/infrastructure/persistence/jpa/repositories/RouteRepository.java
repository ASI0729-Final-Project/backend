package com.acme.center.platform.routes.infrastructure.persistence.jpa.repositories;


import com.acme.center.platform.routes.domain.model.aggregates.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {}
