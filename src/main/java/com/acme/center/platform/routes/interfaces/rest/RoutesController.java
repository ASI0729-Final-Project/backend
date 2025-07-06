package com.acme.center.platform.routes.interfaces.rest;

import com.acme.center.platform.routes.domain.model.queries.GetAllRoutesQuery;
import com.acme.center.platform.routes.domain.services.RouteCommandService;
import com.acme.center.platform.routes.domain.services.RouteQueryService;
import com.acme.center.platform.routes.interfaces.rest.resources.CreateRouteResource;
import com.acme.center.platform.routes.interfaces.rest.resources.RouteResource;
import com.acme.center.platform.routes.interfaces.rest.transform.CreateRouteCommandFromResourceAssembler;
import com.acme.center.platform.routes.interfaces.rest.transform.RouteResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/routes")
@Tag(name = "Routes", description = "Routes Endpoints")
public class  RoutesController {
    private final RouteCommandService routeCommandService;
    private final RouteQueryService routeQueryService;

    public RoutesController(RouteCommandService routeCommandService, RouteQueryService routeQueryService) {
        this.routeCommandService = routeCommandService;
        this.routeQueryService = routeQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new route")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Route created"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    public ResponseEntity<RouteResource> createRoute(@RequestBody CreateRouteResource resource) {
        var command = CreateRouteCommandFromResourceAssembler.toCommandFromResource(resource);
        var route = routeCommandService.handle(command);
        if (route.isEmpty()) return ResponseEntity.badRequest().build();
        var routeResource = RouteResourceFromEntityAssembler.toResourceFromEntity(route.get());
        return ResponseEntity.status(201).body(routeResource);
    }

    @GetMapping
    @Operation(summary = "Get all routes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Routes retrieved"),
            @ApiResponse(responseCode = "404", description = "No routes found")
    })
    public ResponseEntity<List<RouteResource>> getAllRoutes() {
        var routes = routeQueryService.handle(new GetAllRoutesQuery());
        if (routes.isEmpty()) return ResponseEntity.notFound().build();
        var routeResources = routes.stream()
                .map(RouteResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(routeResources);
    }
}
