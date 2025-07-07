package com.acme.center.platform.requests.interfaces.rest;

import com.acme.center.platform.requests.domain.model.queries.GetAllRequestsQuery;
import com.acme.center.platform.requests.domain.model.queries.GetRequestByIdQuery;
import com.acme.center.platform.requests.domain.services.RequestCommandService;
import com.acme.center.platform.requests.domain.services.RequestQueryService;
import com.acme.center.platform.requests.interfaces.rest.resources.CreateRequestResource;
import com.acme.center.platform.requests.interfaces.rest.resources.RequestResource;
import com.acme.center.platform.requests.interfaces.rest.transform.CreateRequestCommandFromResourceAssembler;
import com.acme.center.platform.requests.interfaces.rest.transform.RequestResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/requests", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Requests", description = "Available Request Endpoints")
public class RequestsController {

    private final RequestCommandService requestCommandService;
    private final RequestQueryService requestQueryService;

    public RequestsController(RequestCommandService requestCommandService, RequestQueryService requestQueryService) {
        this.requestCommandService = requestCommandService;
        this.requestQueryService = requestQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Request created"),
            @ApiResponse(responseCode = "400", description = "Bad request")})
    public ResponseEntity<RequestResource> createRequest(@RequestBody CreateRequestResource resource) {
        var command = CreateRequestCommandFromResourceAssembler.toCommandFromResource(resource);
        var request = requestCommandService.handle(command);
        if (request.isEmpty()) return ResponseEntity.badRequest().build();
        var createdRequest = request.get();
        var requestResource = RequestResourceFromEntityAssembler.toResourceFromEntity(createdRequest);
        return new ResponseEntity<>(requestResource, HttpStatus.CREATED);
    }

    @GetMapping("/{requestId}")
    @Operation(summary = "Get a request by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Request found"),
            @ApiResponse(responseCode = "404", description = "Request not found")})
    public ResponseEntity<RequestResource> getRequestById(@PathVariable Long requestId) {
        var query = new GetRequestByIdQuery(requestId);
        var request = requestQueryService.handle(query);
        if (request.isEmpty()) return ResponseEntity.notFound().build();
        var requestEntity = request.get();
        var requestResource = RequestResourceFromEntityAssembler.toResourceFromEntity(requestEntity);
        return ResponseEntity.ok(requestResource);
    }

    @GetMapping
    @Operation(summary = "Get all requests")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requests found"),
            @ApiResponse(responseCode = "404", description = "Requests not found")})
    public ResponseEntity<List<RequestResource>> getAllRequests() {
        var requests = requestQueryService.handle(new GetAllRequestsQuery());
        if (requests.isEmpty()) return ResponseEntity.notFound().build();
        var resources = requests.stream()
                .map(RequestResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
}
