package com.indra.recruiter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProfileDetailRequest(
        @NotNull UUID profileId,
        @NotBlank String detailKey,
        String detailValue
) {
}
