package com.indra.recruiter.mapper;

import com.indra.recruiter.dto.CollaboratorResponse;
import com.indra.recruiter.entity.CollaboratorEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CollaboratorMapper {

    public CollaboratorResponse toResponse(CollaboratorEntity entity) {
        if (entity == null) {
            return null;
        }

        return new CollaboratorResponse(
                entity.getId(),
                entity.getFullName(),
                entity.getEmail(),
                entity.getStatus() != null ? entity.getStatus().getId() : null,
                entity.getStatus() != null ? entity.getStatus().getName() : null,
                entity.getProfile() != null ? entity.getProfile().getId() : null,
                entity.getProfile() != null ? entity.getProfile().getName() : null,
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
