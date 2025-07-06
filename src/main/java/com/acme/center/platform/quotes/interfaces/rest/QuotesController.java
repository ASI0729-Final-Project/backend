package com.acme.center.platform.quotes.interfaces.rest;

import com.acme.center.platform.quotes.domain.model.queries.GetAllQuotesQuery;
import com.acme.center.platform.quotes.domain.services.QuoteCommandService;
import com.acme.center.platform.quotes.domain.services.QuoteQueryService;
import com.acme.center.platform.quotes.interfaces.rest.resources.CreateQuoteResource;
import com.acme.center.platform.quotes.interfaces.rest.resources.QuoteResource;
import com.acme.center.platform.quotes.interfaces.rest.transform.CreateQuoteCommandFromResourceAssembler;
import com.acme.center.platform.quotes.interfaces.rest.transform.QuoteResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/quotes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Quotes", description = "Available Quote Endpoints")
public class QuotesController {

    private final QuoteCommandService quoteCommandService;
    private final QuoteQueryService quoteQueryService;

    public QuotesController(QuoteCommandService quoteCommandService, QuoteQueryService quoteQueryService) {
        this.quoteCommandService = quoteCommandService;
        this.quoteQueryService = quoteQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new quote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Quote created"),
            @ApiResponse(responseCode = "400", description = "Bad request")})
    public ResponseEntity<QuoteResource> createQuote(@RequestBody CreateQuoteResource resource) {
        var createQuoteCommand = CreateQuoteCommandFromResourceAssembler.toCommandFromResource(resource);
        var quote = quoteCommandService.handle(createQuoteCommand);
        if (quote.isEmpty()) return ResponseEntity.badRequest().build();
        var createdQuote = quote.get();
        var quoteResource = QuoteResourceFromEntityAssembler.toResourceFromEntity(createdQuote);
        return new ResponseEntity<>(quoteResource, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all quotes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quotes found"),
            @ApiResponse(responseCode = "404", description = "Quotes not found")})
    public ResponseEntity<List<QuoteResource>> getAllQuotes() {
        var quotes = quoteQueryService.handle(new GetAllQuotesQuery());
        if (quotes.isEmpty()) return ResponseEntity.notFound().build();
        var quoteResources = quotes.stream()
                .map(QuoteResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(quoteResources);
    }
}
