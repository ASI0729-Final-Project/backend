package com.acme.center.platform.drivercomments.application.internal.commandservices;

import com.acme.center.platform.drivercomments.domain.model.aggregates.DriverComment;
import com.acme.center.platform.drivercomments.domain.model.commands.CreateDriverCommentCommand;
import com.acme.center.platform.drivercomments.domain.services.DriverCommentCommandService;
import com.acme.center.platform.drivercomments.infrastructure.persistence.jpa.repositories.DriverCommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DriverCommentCommandServiceImpl implements DriverCommentCommandService {
    private final DriverCommentRepository driverCommentRepository;

    public DriverCommentCommandServiceImpl(DriverCommentRepository driverCommentRepository) {
        this.driverCommentRepository = driverCommentRepository;
    }

    @Override
    public Optional<DriverComment> handle(CreateDriverCommentCommand command) {
        var driverComment = new DriverComment(command);
        var savedComment = driverCommentRepository.save(driverComment);
        return Optional.of(savedComment);
    }
}
