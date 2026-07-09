package com.indra.recruiter.dto;

import java.time.Instant;
import java.util.UUID;

public record StatusResponse(
        UUID id,
        String name,
        String description,
        Instant createdAt,
        Instant updatedAt
) {
}
