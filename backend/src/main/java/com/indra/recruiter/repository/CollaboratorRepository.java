package com.indra.recruiter.repository;

import com.indra.recruiter.entity.CollaboratorEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class CollaboratorRepository implements PanacheRepositoryBase<CollaboratorEntity, UUID> {

    public CollaboratorEntity findByIdOrThrow(UUID collaboratorId) {
        return findById(collaboratorId);
    }
}
