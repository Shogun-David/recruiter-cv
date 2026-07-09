package com.indra.recruiter.repository;

import com.indra.recruiter.entity.ProfileDetailEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ProfileDetailRepository implements PanacheRepositoryBase<ProfileDetailEntity, UUID> {

    public ProfileDetailEntity findByIdOrThrow(UUID detailId) {
        return findById(detailId);
    }
}
