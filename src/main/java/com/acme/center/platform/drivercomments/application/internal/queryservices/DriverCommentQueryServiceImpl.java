package com.acme.center.platform.drivercomments.application.internal.queryservices;

import com.acme.center.platform.drivercomments.domain.model.aggregates.DriverComment;
import com.acme.center.platform.drivercomments.domain.model.queries.GetAllDriverCommentsQuery;
import com.acme.center.platform.drivercomments.domain.model.queries.GetDriverCommentByIdQuery;
import com.acme.center.platform.drivercomments.domain.services.DriverCommentQueryService;
import com.acme.center.platform.drivercomments.infrastructure.persistence.jpa.repositories.DriverCommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DriverCommentQueryServiceImpl implements DriverCommentQueryService {
    private final DriverCommentRepository driverCommentRepository;

    public DriverCommentQueryServiceImpl(DriverCommentRepository driverCommentRepository) {
        this.driverCommentRepository = driverCommentRepository;
    }

    @Override
    public Optional<DriverComment> handle(GetDriverCommentByIdQuery query) {
        return driverCommentRepository.findById(query.driverCommentId());
    }

    @Override
    public List<DriverComment> handle(GetAllDriverCommentsQuery query) {
        return driverCommentRepository.findAll();
    }
}
