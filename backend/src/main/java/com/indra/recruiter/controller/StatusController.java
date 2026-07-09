package com.indra.recruiter.controller;

import com.indra.recruiter.dto.StatusRequest;
import com.indra.recruiter.dto.StatusResponse;
import com.indra.recruiter.service.StatusService;
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

@Path("/statuses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusController {

    @Inject
    StatusService statusService;

    @POST
    public StatusResponse create(@Valid StatusRequest request) {
        return statusService.create(request);
    }

    @GET
    public List<StatusResponse> list() {
        return statusService.list();
    }

    @GET
    @Path("/{id}")
    public StatusResponse findById(@PathParam("id") UUID id) {
        return statusService.findById(id);
    }

    @PUT
    @Path("/{id}")
    public StatusResponse update(@PathParam("id") UUID id, @Valid StatusRequest request) {
        return statusService.update(id, request);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") UUID id) {
        statusService.delete(id);
    }
}
