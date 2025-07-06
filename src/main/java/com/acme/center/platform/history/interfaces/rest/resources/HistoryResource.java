package com.acme.center.platform.history.interfaces.rest.resources;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryResource {
    private Long id;
    private String driver;
    private String from;
    private String to;
    private String date;
    private String hour;
    private double pay;
    private String state;
    private Long routeId;
}
