package com.acme.center.platform.history.interfaces;

import com.acme.center.platform.history.domain.model.aggregates.History;
import com.acme.center.platform.history.domain.model.commands.CreateHistoryCommand;
import com.acme.center.platform.history.domain.model.queries.*;
import com.acme.center.platform.history.domain.services.HistoryCommandService;
import com.acme.center.platform.history.domain.services.HistoryQueryService;
import com.acme.center.platform.history.interfaces.rest.resources.*;
import com.acme.center.platform.history.interfaces.rest.transform.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/history", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "History", description = "Endpoints for managing travel history")
public class HistoryController {

    private final HistoryCommandService commandService;
    private final HistoryQueryService queryService;

    public HistoryController(HistoryCommandService commandService, HistoryQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    @Operation(summary = "Create a new history entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "History entry created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<HistoryResource> create(@RequestBody CreateHistoryResource resource) {
        var command = CreateHistoryCommandFromResourceAssembler.toCommandFromResource(resource);
        var history = commandService.handle(command);
        return history.map(value ->
                        ResponseEntity.status(HttpStatus.CREATED)
                                .body(HistoryResourceFromEntityAssembler.toResourceFromEntity(value)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    @Operation(summary = "Get all history entries")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all history entries")
    })
    public List<HistoryResource> getAll() {
        return queryService.handle(new GetAllHistoryQuery()).stream()
                .map(HistoryResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-date/{date}")
    @Operation(summary = "Get history entries by date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of history entries for the date")
    })
    public List<HistoryResource> getByDate(@PathVariable String date) {
        return queryService.handle(new GetHistoryByDateQuery(date)).stream()
                .map(HistoryResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-state/{state}")
    @Operation(summary = "Get history entries by state")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of history entries for the state")
    })
    public List<HistoryResource> getByState(@PathVariable String state) {
        return queryService.handle(new GetHistoryByStateQuery(state)).stream()
                .map(HistoryResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
    }
}
