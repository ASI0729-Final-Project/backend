package com.acme.center.platform.quotes.domain.services;

import com.acme.center.platform.quotes.domain.model.aggregates.Quote;
import com.acme.center.platform.quotes.domain.model.commands.CreateQuoteCommand;

import java.util.Optional;

public interface QuoteCommandService {
    Optional<Quote> handle(CreateQuoteCommand command);
}
