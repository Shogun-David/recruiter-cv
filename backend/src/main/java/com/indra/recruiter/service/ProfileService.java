package com.indra.recruiter.service;

import com.indra.recruiter.dto.ProfileDetailRequest;
import com.indra.recruiter.dto.ProfileDetailResponse;
import com.indra.recruiter.dto.ProfileRequest;
import com.indra.recruiter.dto.ProfileResponse;
import com.indra.recruiter.entity.ProfileDetailEntity;
import com.indra.recruiter.entity.ProfileEntity;
import com.indra.recruiter.mapper.ProfileMapper;
import com.indra.recruiter.repository.ProfileDetailRepository;
import com.indra.recruiter.repository.ProfileRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class ProfileService {

    @Inject
    ProfileRepository profileRepository;

    @Inject
    ProfileDetailRepository profileDetailRepository;

    @Inject
    ProfileMapper profileMapper;

    public ProfileResponse create(ProfileRequest request) {
        ProfileEntity profile = new ProfileEntity();
        profile.setName(request.name());
        profile.setDescription(request.description());

        profileRepository.persist(profile);
        return profileMapper.toResponse(profile);
    }

    public List<ProfileResponse> list() {
        return profileRepository.findAll().stream()
                .map(profileMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProfileResponse findById(UUID id) {
        ProfileEntity profile = profileRepository.findById(id);
        if (profile == null) {
            throw new NotFoundException("Profile not found: " + id);
        }
        return profileMapper.toResponse(profile);
    }

    public ProfileResponse update(UUID id, ProfileRequest request) {
        ProfileEntity profile = profileRepository.findById(id);
        if (profile == null) {
            throw new NotFoundException("Profile not found: " + id);
        }
        profile.setName(request.name());
        profile.setDescription(request.description());
        return profileMapper.toResponse(profile);
    }

    public void delete(UUID id) {
        boolean deleted = profileRepository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Profile not found: " + id);
        }
    }

    public ProfileDetailResponse addDetail(ProfileDetailRequest request) {
        ProfileEntity profile = profileRepository.findById(request.profileId());
        if (profile == null) {
            throw new NotFoundException("Profile not found: " + request.profileId());
        }

        ProfileDetailEntity detail = new ProfileDetailEntity();
        detail.setProfile(profile);
        detail.setDetailKey(request.detailKey());
        detail.setDetailValue(request.detailValue());

        profileDetailRepository.persist(detail);
        profile.getDetails().add(detail);
        return profileMapper.toDetailResponse(detail);
    }

    public void deleteDetail(UUID id) {
        boolean deleted = profileDetailRepository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Profile detail not found: " + id);
        }
    }
}
