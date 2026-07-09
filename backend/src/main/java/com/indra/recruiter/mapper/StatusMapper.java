package com.indra.recruiter.mapper;

import com.indra.recruiter.dto.StatusResponse;
import com.indra.recruiter.entity.StatusEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StatusMapper {

    public StatusResponse toResponse(StatusEntity entity) {
        if (entity == null) {
            return null;
        }
        return new StatusResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
