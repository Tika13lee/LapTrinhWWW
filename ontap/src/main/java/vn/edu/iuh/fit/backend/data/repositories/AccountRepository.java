package vn.edu.iuh.fit.backend.data.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.data.entities.Account;

public class AccountRepository {
    @PersistenceContext(name = "demo_pu")
    private EntityManager entityManager;

    public void save(Account account) {
        entityManager.persist(account);
    }
}
