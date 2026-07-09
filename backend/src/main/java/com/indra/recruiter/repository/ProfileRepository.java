package com.indra.recruiter.repository;

import com.indra.recruiter.entity.ProfileEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ProfileRepository implements PanacheRepositoryBase<ProfileEntity, UUID> {

    public ProfileEntity findByIdOrThrow(UUID profileId) {
        return findById(profileId);
    }
}
