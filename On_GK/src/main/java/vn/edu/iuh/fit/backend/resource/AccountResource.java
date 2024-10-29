package vn.edu.iuh.fit.backend.resource;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.business.AccountLocal;
import vn.edu.iuh.fit.backend.data.entities.Account;

@Path("/account")
public class AccountResource {
    @EJB
    private AccountLocal accountLocal;

    @POST
    @Consumes("application/json")
    public Response save(Account account) {
        accountLocal.addAccount(account);
        return Response.ok().build();
    }

    @GET
//    @Path("/list")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getAllAccount() {
        return Response.ok().entity(accountLocal.getAllAccount()).build();
    }

    @POST
    @Path("/delete/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteAccount(@PathParam("id") int id) {
        if (accountLocal.deleteAccount(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateAccount(Account account) {
        if (accountLocal.updateAccount(account)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/findByName")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getByUsername(@QueryParam("us") String us) {
        return Response.ok().entity(accountLocal.getByUsername(us)).build();
    }

    @GET
    @Path("/findByBalance")
    @Consumes("application/json")
    @Produces("application/json")
    public Response findByBalance(@QueryParam("min") int min, @QueryParam("max") int max) {
        return Response.ok().entity(accountLocal.findByBalance(min, max)).build();
    }

}
