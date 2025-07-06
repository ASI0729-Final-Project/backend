package com.acme.center.platform.drivercomments.interfaces.rest;

import com.acme.center.platform.drivercomments.domain.model.queries.GetAllDriverCommentsQuery;
import com.acme.center.platform.drivercomments.domain.model.queries.GetDriverCommentByIdQuery;
import com.acme.center.platform.drivercomments.domain.services.DriverCommentCommandService;
import com.acme.center.platform.drivercomments.domain.services.DriverCommentQueryService;
import com.acme.center.platform.drivercomments.interfaces.rest.resources.CreateDriverCommentResource;
import com.acme.center.platform.drivercomments.interfaces.rest.resources.DriverCommentResource;
import com.acme.center.platform.drivercomments.interfaces.rest.transform.CreateDriverCommentCommandFromResourceAssembler;
import com.acme.center.platform.drivercomments.interfaces.rest.transform.DriverCommentResourceFromEntityAssembler;
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
@RequestMapping(value = "/api/v1/driver-comments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "DriverComments", description = "Available Driver Comment Endpoints")
public class DriverCommentsController {
    private final DriverCommentCommandService driverCommentCommandService;
    private final DriverCommentQueryService driverCommentQueryService;

    public DriverCommentsController(DriverCommentCommandService driverCommentCommandService, DriverCommentQueryService driverCommentQueryService) {
        this.driverCommentCommandService = driverCommentCommandService;
        this.driverCommentQueryService = driverCommentQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new driver comment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Driver comment created"),
            @ApiResponse(responseCode = "400", description = "Bad request")})
    public ResponseEntity<DriverCommentResource> createDriverComment(@RequestBody CreateDriverCommentResource resource) {
        var command = CreateDriverCommentCommandFromResourceAssembler.toCommandFromResource(resource);
        var driverComment = driverCommentCommandService.handle(command);
        if (driverComment.isEmpty()) return ResponseEntity.badRequest().build();
        var createdComment = driverComment.get();
        var resourceResponse = DriverCommentResourceFromEntityAssembler.toResourceFromEntity(createdComment);
        return new ResponseEntity<>(resourceResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{driverCommentId}")
    @Operation(summary = "Get a driver comment by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Driver comment found"),
            @ApiResponse(responseCode = "404", description = "Driver comment not found")})
    public ResponseEntity<DriverCommentResource> getDriverCommentById(@PathVariable Long driverCommentId) {
        var query = new GetDriverCommentByIdQuery(driverCommentId);
        var driverComment = driverCommentQueryService.handle(query);
        if (driverComment.isEmpty()) return ResponseEntity.notFound().build();
        var entity = driverComment.get();
        var resourceResponse = DriverCommentResourceFromEntityAssembler.toResourceFromEntity(entity);
        return ResponseEntity.ok(resourceResponse);
    }

    @GetMapping
    @Operation(summary = "Get all driver comments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Driver comments found"),
            @ApiResponse(responseCode = "404", description = "No driver comments found")})
    public ResponseEntity<List<DriverCommentResource>> getAllDriverComments() {
        var comments = driverCommentQueryService.handle(new GetAllDriverCommentsQuery());
        if (comments.isEmpty()) return ResponseEntity.notFound().build();
        var resources = comments.stream()
                .map(DriverCommentResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
}
