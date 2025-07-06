package com.acme.center.platform.history.domain.model.commands;

public record CreateHistoryCommand(
        String driver,
        String from,
        String to,
        String date,
        String hour,
        Double pay,
        String state,
        Long routeId
) {}
