package com.indra.recruiter.service;

import com.indra.recruiter.dto.StatusRequest;
import com.indra.recruiter.dto.StatusResponse;
import com.indra.recruiter.entity.StatusEntity;
import com.indra.recruiter.mapper.StatusMapper;
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
public class StatusService {

    @Inject
    StatusRepository statusRepository;

    @Inject
    StatusMapper statusMapper;

    public StatusResponse create(StatusRequest request) {
        StatusEntity status = new StatusEntity();
        status.setName(request.name());
        status.setDescription(request.description());

        statusRepository.persist(status);
        return statusMapper.toResponse(status);
    }

    public List<StatusResponse> list() {
        return statusRepository.findAll().stream()
                .map(statusMapper::toResponse)
                .collect(Collectors.toList());
    }

    public StatusResponse findById(UUID id) {
        StatusEntity status = statusRepository.findById(id);
        if (status == null) {
            throw new NotFoundException("Status not found: " + id);
        }
        return statusMapper.toResponse(status);
    }

    public StatusResponse update(UUID id, StatusRequest request) {
        StatusEntity status = statusRepository.findById(id);
        if (status == null) {
            throw new NotFoundException("Status not found: " + id);
        }
        status.setName(request.name());
        status.setDescription(request.description());
        return statusMapper.toResponse(status);
    }

    public void delete(UUID id) {
        boolean deleted = statusRepository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Status not found: " + id);
        }
    }
}
