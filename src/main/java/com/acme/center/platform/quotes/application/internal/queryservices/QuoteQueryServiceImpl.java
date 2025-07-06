package com.acme.center.platform.quotes.application.internal.queryservices;

import com.acme.center.platform.quotes.domain.model.aggregates.Quote;
import com.acme.center.platform.quotes.domain.model.queries.GetAllQuotesQuery;
import com.acme.center.platform.quotes.domain.services.QuoteQueryService;
import com.acme.center.platform.quotes.infrastructure.persistence.jpa.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteQueryServiceImpl implements QuoteQueryService {

    private final QuoteRepository quoteRepository;

    public QuoteQueryServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public List<Quote> handle(GetAllQuotesQuery query) {
        return quoteRepository.findAll();
    }
}
