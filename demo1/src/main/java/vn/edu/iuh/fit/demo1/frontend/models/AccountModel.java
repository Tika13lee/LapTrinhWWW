package vn.edu.iuh.fit.demo1.frontend.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.demo1.backend.data.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountModel {
    private static final String BASE_URI = "http://localhost:8080/demo1-1.0-SNAPSHOT/api";

    public boolean addAccount(Account account) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(BASE_URI + "/account");
            Response response = target.request("application/json").post(Entity.json(account));
            return response.getStatus() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> getAccounts() {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(BASE_URI + "/account/list");
            Response response = target.request("application/json").get();
            String result = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Account.class));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ArrayList<>();
    }

    public List<Account> getAccountsByUsername( String username) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(BASE_URI + "/account/filterList?username=" + username);
            Response response = target.request("application/json").get();
            String result = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Account.class));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ArrayList<>();
    }

    public Account getAccountById(String id) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(BASE_URI + "/account/accountById?id=" + id);
            Response response = target.request("application/json").get();
            String result = response.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(result, Account.class);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public boolean deleteAccount(String id) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(BASE_URI + "/account/delete?id=" + id);
            Response response = target.request("application/json").post(Entity.json(id));
            return response.getStatus() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
