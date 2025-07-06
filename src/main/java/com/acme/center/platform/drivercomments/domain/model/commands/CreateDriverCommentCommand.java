package com.acme.center.platform.drivercomments.domain.model.commands;

public record CreateDriverCommentCommand(Long driverId, String comment, Integer rating) {}
