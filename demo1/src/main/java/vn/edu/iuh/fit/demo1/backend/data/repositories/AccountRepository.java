package vn.edu.iuh.fit.demo1.backend.data.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.demo1.backend.data.entities.Account;

import java.util.List;

public class AccountRepository {
    @PersistenceContext(name="my_pu")
    private EntityManager entityManager;

    public void save(Account account) {
        entityManager.persist(account);
    }

    public List<Account> findAll() {
        return entityManager.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

    public Account findById(String id) {
        return entityManager.find(Account.class, id);
    }

    public List<Account> findByUsername(String username) {
        return entityManager.createNamedQuery("Account.findByUsername", Account.class).setParameter("username", username).getResultList();
    }

    public boolean delete(String id) {
        return entityManager.createNamedQuery("Account.deleteById").setParameter("id", id).executeUpdate() > 0;
    }
}
