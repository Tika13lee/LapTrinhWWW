package vn.edu.iuh.fit.backend.resource;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.business.AccountLocal;
import vn.edu.iuh.fit.backend.data.entities.Account;

@Path("/account")
public class AccountResource {
    @EJB
    private AccountLocal accountLocal;

    // Add the save method here
    @POST
    @Consumes("application/json")
    public Response save(Account account){
        accountLocal.save(account);
        return Response.ok().build();
    }

}
