package com.indra.recruiter.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public record MatchingRequest(
        @NotBlank String query,
        List<String> skills,
        List<String> experience,
        List<String> certifications,
        List<String> languages
) {
}
