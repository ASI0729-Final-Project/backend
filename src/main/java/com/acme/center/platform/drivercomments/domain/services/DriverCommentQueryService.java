package com.acme.center.platform.drivercomments.domain.services;

import com.acme.center.platform.drivercomments.domain.model.aggregates.DriverComment;
import com.acme.center.platform.drivercomments.domain.model.queries.GetAllDriverCommentsQuery;
import com.acme.center.platform.drivercomments.domain.model.queries.GetDriverCommentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DriverCommentQueryService {
    Optional<DriverComment> handle(GetDriverCommentByIdQuery query);
    List<DriverComment> handle(GetAllDriverCommentsQuery query);
}
