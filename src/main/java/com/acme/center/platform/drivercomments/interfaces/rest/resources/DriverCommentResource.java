package com.acme.center.platform.drivercomments.interfaces.rest.resources;

public record DriverCommentResource(Long id, Long driverId, String comment, Integer rating) {}
