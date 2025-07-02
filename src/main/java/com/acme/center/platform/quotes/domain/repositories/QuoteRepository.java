package com.acme.center.platform.quotes.domain.repositories;

import com.acme.center.platform.quotes.domain.model.aggregates.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {}
