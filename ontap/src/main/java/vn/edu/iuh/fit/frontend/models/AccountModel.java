package vn.edu.iuh.fit.frontend.models;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.data.entities.Account;

public class AccountModel {
    private static final String BASED_URI = "http://localhost:8080/Bt_www-1.0-SNAPSHOT/api";

    public void addAccount(Account account) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(BASED_URI + "/account");
            Response response = target.request("application/json").post(Entity.json(account));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
