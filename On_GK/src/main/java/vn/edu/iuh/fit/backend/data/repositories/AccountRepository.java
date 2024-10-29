package vn.edu.iuh.fit.backend.data.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.backend.data.entities.Account;

import java.util.List;

public class AccountRepository {
    @PersistenceContext(name = "my_pu")
    private EntityManager entityManager;

    public boolean saveAccount(Account account) {
        try {
            entityManager.persist(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> findAllAccount() {
        return entityManager.createNamedQuery(("Account.findAll"), Account.class).getResultList();
    }

    public boolean deleteAccount(int id) {
        try {
            entityManager.createNamedQuery("Account.deleteById")
                    .setParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAccount(Account account) {
        try {
            entityManager.merge(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> getByUsername(String us) {
        return entityManager.createNamedQuery(("Account.findByUsername"), Account.class)
                .setParameter("username", us)
                .getResultList();
    }

    public List<Account> findByBalance(int min, int max) {
        return entityManager.createNamedQuery(("Account.findByBalance"), Account.class)
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }
}
