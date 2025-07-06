package com.acme.center.platform.quotes.application.internal.commandservices;

import com.acme.center.platform.quotes.domain.model.aggregates.Quote;
import com.acme.center.platform.quotes.domain.model.commands.CreateQuoteCommand;
import com.acme.center.platform.quotes.infrastructure.persistence.jpa.repositories.QuoteRepository;
import com.acme.center.platform.quotes.domain.services.QuoteCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuoteCommandServiceImpl implements QuoteCommandService {

    private final QuoteRepository quoteRepository;

    public QuoteCommandServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public Optional<Quote> handle(CreateQuoteCommand command) {
        var quote = new Quote(command);
        return Optional.of(quoteRepository.save(quote));
    }
}
