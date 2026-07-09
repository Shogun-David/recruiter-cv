package com.indra.recruiter.dto;

import java.util.List;
import java.util.UUID;

public record MatchingResponse(
        UUID collaboratorId,
        String collaboratorName,
        UUID profileId,
        String profileName,
        double score,
        List<String> strengths,
        List<String> weaknesses,
        String explanation
) {
}
