package com.indra.recruiter.dto;

import java.time.Instant;
import java.util.UUID;

public record ProfileDetailResponse(
        UUID id,
        UUID profileId,
        String detailKey,
        String detailValue,
        Instant createdAt,
        Instant updatedAt
) {
}
