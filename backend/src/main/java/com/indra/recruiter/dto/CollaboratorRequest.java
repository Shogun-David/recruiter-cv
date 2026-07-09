package com.indra.recruiter.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CollaboratorRequest(
        @NotBlank String fullName,
        @NotBlank @Email String email,
        @NotNull UUID statusId,
        UUID profileId
) {
}
