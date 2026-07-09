package com.indra.recruiter.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record ProfileResponse(
        UUID id,
        String name,
        String description,
        List<ProfileDetailResponse> details,
        Instant createdAt,
        Instant updatedAt
) {
}
