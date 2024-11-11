package vn.edu.iuh.fit.demo1.backend.resource;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.demo1.backend.business.AccountLocal;
import vn.edu.iuh.fit.demo1.backend.data.entities.Account;

@Path("/account")
public class AccountResource {
    @EJB
    private AccountLocal accountLocal;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response save(Account account) {
        accountLocal.save(account);
        return Response.ok().build();
    }

    @GET
    @Path("/list")
    @Produces("application/json")
    @Consumes("application/json")
    public Response findAll() {
        return Response.ok().entity((accountLocal.findAll())).build();
    }

    @GET
    @Path("/filterList")
    @Produces("application/json")
    @Consumes("application/json")
    public Response findByUsername(@QueryParam("username") String username) {
        return Response.ok().entity((accountLocal.findByUsername(username))).build();
    }

    @GET
    @Path("/accountById")
    @Produces("application/json")
    @Consumes("application/json")
    public Response findById(@QueryParam("id") String id) {
        return Response.ok().entity((accountLocal.findById(id))).build();
    }

    @POST
    @Path("/delete")
    @Produces("application/json")
    @Consumes("application/json")
    public Response delete(@QueryParam("id") String id) {
        return Response.ok().entity((accountLocal.delete(id))).build();
    }
}
