package com.acme.center.platform.quotes.domain.services;

import com.acme.center.platform.quotes.domain.model.aggregates.Quote;
import com.acme.center.platform.quotes.domain.model.queries.GetAllQuotesQuery;

import java.util.List;

public interface QuoteQueryService {
    List<Quote> handle(GetAllQuotesQuery query);
}
