package com.indra.recruiter.mapper;

import com.indra.recruiter.dto.ProfileDetailResponse;
import com.indra.recruiter.dto.ProfileResponse;
import com.indra.recruiter.entity.ProfileEntity;
import com.indra.recruiter.entity.ProfileDetailEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.stream.Collectors;

@ApplicationScoped
public class ProfileMapper {

    public ProfileResponse toResponse(ProfileEntity entity) {
        if (entity == null) {
            return null;
        }

        return new ProfileResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getDetails().stream().map(this::toDetailResponse).collect(Collectors.toList()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public ProfileDetailResponse toDetailResponse(ProfileDetailEntity entity) {
        if (entity == null) {
            return null;
        }

        return new ProfileDetailResponse(
                entity.getId(),
                entity.getProfile() != null ? entity.getProfile().getId() : null,
                entity.getDetailKey(),
                entity.getDetailValue(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
