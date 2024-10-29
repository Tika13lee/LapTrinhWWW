package vn.edu.iuh.fit.backend.data.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.data.entities.Account;

public class AccountRepository {
    @PersistenceContext(name = "demo_pu")
    private EntityManager entityManager;

    public boolean addAccount(Account account) {
        try {
            entityManager.persist(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
