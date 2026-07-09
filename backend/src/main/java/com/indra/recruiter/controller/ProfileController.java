package com.indra.recruiter.controller;

import com.indra.recruiter.dto.ProfileDetailRequest;
import com.indra.recruiter.dto.ProfileDetailResponse;
import com.indra.recruiter.dto.ProfileRequest;
import com.indra.recruiter.dto.ProfileResponse;
import com.indra.recruiter.service.ProfileService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileController {

    @Inject
    ProfileService profileService;

    @POST
    public ProfileResponse create(@Valid ProfileRequest request) {
        return profileService.create(request);
    }

    @GET
    public List<ProfileResponse> list() {
        return profileService.list();
    }

    @GET
    @Path("/{id}")
    public ProfileResponse findById(@PathParam("id") UUID id) {
        return profileService.findById(id);
    }

    @PUT
    @Path("/{id}")
    public ProfileResponse update(@PathParam("id") UUID id, @Valid ProfileRequest request) {
        return profileService.update(id, request);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") UUID id) {
        profileService.delete(id);
    }

    @POST
    @Path("/details")
    public ProfileDetailResponse addDetail(@Valid ProfileDetailRequest request) {
        return profileService.addDetail(request);
    }

    @DELETE
    @Path("/details/{id}")
    public void deleteDetail(@PathParam("id") UUID id) {
        profileService.deleteDetail(id);
    }
}
