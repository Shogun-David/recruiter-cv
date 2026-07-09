package com.indra.recruiter.dto;

import jakarta.validation.constraints.NotBlank;

public record ProfileRequest(
        @NotBlank String name,
        String description
) {
}
