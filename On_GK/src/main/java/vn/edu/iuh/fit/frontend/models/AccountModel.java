package vn.edu.iuh.fit.frontend.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.data.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountModel {
    public boolean addAccount(Account account) {
        Response res = null;
        try (Client client = ClientBuilder.newClient();) {
            WebTarget target = client.target("http://localhost:8080/On_GK-1.0-SNAPSHOT/api/account");
            res = target.request("application/json").post(Entity.json(account));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return res.getStatus() == 200;
    }

    public List<Account> getAllAccount() {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target("http://localhost:8080/On_GK-1.0-SNAPSHOT/api/account");
            Response res = target.request("application/json").get();
            String result = res.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            List<Account> accounts = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Account.class));
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public boolean deleteAccount(int id) {
        Response res = null;
        try (Client client = ClientBuilder.newClient();) {
            WebTarget target = client.target("http://localhost:8080/On_GK-1.0-SNAPSHOT/api/account/delete/" + id);
            res = target.request("application/json").post(Entity.json(id));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return res.getStatus() == 200;
    }

    public boolean updateAccount(Account account) {
        Response res = null;
        try (Client client = ClientBuilder.newClient();) {
            WebTarget target = client.target("http://localhost:8080/On_GK-1.0-SNAPSHOT/api/account/update");
            res = target.request("application/json").post(Entity.json(account));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return res.getStatus() == 200;
    }

    public List<Account> getByUsername(String us) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target("http://localhost:8080/On_GK-1.0-SNAPSHOT/api/account/findByName?us=" + us);
            Response res = target.request("application/json").get();
            String result = res.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            List<Account> accounts = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Account.class));
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Account> findByBalance(int min, int max) {
        try (Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target("http://localhost:8080/On_GK-1.0-SNAPSHOT/api/account/findByBalance?min=" + min + "&max=" + max);
            Response res = target.request("application/json").get();
            String result = res.readEntity(String.class);
            ObjectMapper mapper = new ObjectMapper();
            List<Account> accounts = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Account.class));
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
