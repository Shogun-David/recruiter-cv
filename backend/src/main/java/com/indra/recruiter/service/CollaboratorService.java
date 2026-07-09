package com.indra.recruiter.service;

import com.indra.recruiter.dto.CollaboratorRequest;
import com.indra.recruiter.dto.CollaboratorResponse;
import com.indra.recruiter.entity.CollaboratorEntity;
import com.indra.recruiter.entity.StatusEntity;
import com.indra.recruiter.mapper.CollaboratorMapper;
import com.indra.recruiter.repository.CollaboratorRepository;
import com.indra.recruiter.repository.ProfileRepository;
import com.indra.recruiter.repository.StatusRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class CollaboratorService {

    @Inject
    CollaboratorRepository collaboratorRepository;

    @Inject
    StatusRepository statusRepository;

    @Inject
    ProfileRepository profileRepository;

    @Inject
    CollaboratorMapper collaboratorMapper;

    public CollaboratorResponse create(CollaboratorRequest request) {
        StatusEntity status = statusRepository.findById(request.statusId());
        if (status == null) {
            throw new NotFoundException("Status not found: " + request.statusId());
        }

        CollaboratorEntity collaborator = new CollaboratorEntity();
        collaborator.setFullName(request.fullName());
        collaborator.setEmail(request.email());
        collaborator.setStatus(status);

        if (request.profileId() != null) {
            var profile = profileRepository.findById(request.profileId());
            if (profile == null) {
                throw new NotFoundException("Profile not found: " + request.profileId());
            }
            collaborator.setProfile(profile);
        }

        collaboratorRepository.persist(collaborator);
        return collaboratorMapper.toResponse(collaborator);
    }

    public List<CollaboratorResponse> list() {
        return collaboratorRepository.findAll().stream()
                .map(collaboratorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CollaboratorResponse findById(UUID id) {
        CollaboratorEntity collaborator = collaboratorRepository.findById(id);
        if (collaborator == null) {
            throw new NotFoundException("Collaborator not found: " + id);
        }
        return collaboratorMapper.toResponse(collaborator);
    }

    public CollaboratorResponse update(UUID id, CollaboratorRequest request) {
        CollaboratorEntity collaborator = collaboratorRepository.findById(id);
        if (collaborator == null) {
            throw new NotFoundException("Collaborator not found: " + id);
        }

        StatusEntity status = statusRepository.findById(request.statusId());
        if (status == null) {
            throw new NotFoundException("Status not found: " + request.statusId());
        }

        collaborator.setFullName(request.fullName());
        collaborator.setEmail(request.email());
        collaborator.setStatus(status);

        if (request.profileId() != null) {
            var profile = profileRepository.findById(request.profileId());
            if (profile == null) {
                throw new NotFoundException("Profile not found: " + request.profileId());
            }
            collaborator.setProfile(profile);
        } else {
            collaborator.setProfile(null);
        }

        return collaboratorMapper.toResponse(collaborator);
    }

    public void delete(UUID id) {
        boolean deleted = collaboratorRepository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Collaborator not found: " + id);
        }
    }
}
