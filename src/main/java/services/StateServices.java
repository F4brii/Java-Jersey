/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.StateDAO;
import models.State;

/**
 *
 * @author fabricio
 */

@Path("/states")
public class StateServices {

    private StateDAO repository = new StateDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayJsonHello() {
        return Response.ok(repository.getStates()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response StateForID(@PathParam("id") int id) {
        return Response.ok(repository.getState(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployee(State state) {
        StateDAO dao = new StateDAO();
        dao.addState(state);
        return Response.ok().build();
    }
}