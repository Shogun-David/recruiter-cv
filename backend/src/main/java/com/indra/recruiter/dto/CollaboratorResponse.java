package com.indra.recruiter.dto;

import java.time.Instant;
import java.util.UUID;

public record CollaboratorResponse(
        UUID id,
        String fullName,
        String email,
        UUID statusId,
        String statusName,
        UUID profileId,
        String profileName,
        Instant createdAt,
        Instant updatedAt
) {
}
