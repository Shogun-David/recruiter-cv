package com.indra.recruiter.controller;

import com.indra.recruiter.dto.CollaboratorRequest;
import com.indra.recruiter.dto.CollaboratorResponse;
import com.indra.recruiter.service.CollaboratorService;
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

@Path("/collaborators")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CollaboratorController {

    @Inject
    CollaboratorService collaboratorService;

    @POST
    public CollaboratorResponse create(@Valid CollaboratorRequest request) {
        return collaboratorService.create(request);
    }

    @GET
    public List<CollaboratorResponse> list() {
        return collaboratorService.list();
    }

    @GET
    @Path("/{id}")
    public CollaboratorResponse findById(@PathParam("id") UUID id) {
        return collaboratorService.findById(id);
    }

    @PUT
    @Path("/{id}")
    public CollaboratorResponse update(@PathParam("id") UUID id, @Valid CollaboratorRequest request) {
        return collaboratorService.update(id, request);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") UUID id) {
        collaboratorService.delete(id);
    }
}
