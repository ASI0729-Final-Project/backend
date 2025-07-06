package com.acme.center.platform.drivercomments.infrastructure.persistence.jpa.repositories;

import com.acme.center.platform.drivercomments.domain.model.aggregates.DriverComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverCommentRepository extends JpaRepository<DriverComment, Long> {}
