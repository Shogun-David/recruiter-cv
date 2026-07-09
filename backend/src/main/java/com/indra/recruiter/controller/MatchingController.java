package com.indra.recruiter.controller;

import com.indra.recruiter.dto.MatchingRequest;
import com.indra.recruiter.dto.MatchingResponse;
import com.indra.recruiter.service.MatchingService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/matching")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MatchingController {

    @Inject
    MatchingService matchingService;

    @POST
    public List<MatchingResponse> search(@Valid MatchingRequest request) {
        return matchingService.findMatches(request);
    }
}
