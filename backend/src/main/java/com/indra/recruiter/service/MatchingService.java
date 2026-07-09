package com.indra.recruiter.service;

import com.indra.recruiter.dto.MatchingRequest;
import com.indra.recruiter.dto.MatchingResponse;
import com.indra.recruiter.dto.CollaboratorResponse;
import com.indra.recruiter.entity.CollaboratorEntity;
import com.indra.recruiter.mapper.CollaboratorMapper;
import com.indra.recruiter.repository.CollaboratorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MatchingService {

    @Inject
    CollaboratorRepository collaboratorRepository;

    @Inject
    CollaboratorMapper collaboratorMapper;

    public List<MatchingResponse> findMatches(MatchingRequest request) {
        List<CollaboratorEntity> candidates = collaboratorRepository.findAll().stream().collect(Collectors.toList());

        return candidates.stream()
                .map(candidate -> scoreCandidate(candidate, request))
                .sorted(Comparator.comparingDouble(MatchingResponse::score).reversed())
                .collect(Collectors.toList());
    }

    private MatchingResponse scoreCandidate(CollaboratorEntity candidate, MatchingRequest request) {
        double baseScore = 50;
        double skillScore = request.skills().stream()
                .filter(skill -> candidate.getEmail() != null && candidate.getEmail().toLowerCase().contains(skill.toLowerCase()))
                .count() * 5.0;

        double score = Math.min(100, baseScore + skillScore);

        return new MatchingResponse(
                candidate.getId(),
                candidate.getFullName(),
                candidate.getProfile() != null ? candidate.getProfile().getId() : null,
                candidate.getProfile() != null ? candidate.getProfile().getName() : null,
                score,
                List.of("Relevancia de perfil"),
                List.of("Requiere ajustes manuales"),
                "Matching realizado por heurística simple."
        );
    }
}
