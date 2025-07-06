package com.acme.center.platform.drivercomments.interfaces.rest.resources;

public record CreateDriverCommentResource(Long driverId, String comment, Integer rating) {
    public CreateDriverCommentResource {
        if (driverId == null || driverId <= 0) throw new IllegalArgumentException("Driver ID is required and must be positive");
        if (comment == null || comment.isBlank()) throw new IllegalArgumentException("Comment is required");
        if (rating == null || rating < 1 || rating > 5) throw new IllegalArgumentException("Rating must be between 1 and 5");
    }
}
