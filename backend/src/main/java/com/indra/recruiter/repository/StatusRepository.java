package com.indra.recruiter.repository;

import com.indra.recruiter.entity.StatusEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class StatusRepository implements PanacheRepositoryBase<StatusEntity, UUID> {

    public StatusEntity findByIdOrThrow(UUID statusId) {
        return findById(statusId);
    }
}
