package vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.entities.Account;

import java.util.List;

public class AccountRepository {
    private EntityManagerFactory emf;

    public AccountRepository() {
        this.emf = Persistence.createEntityManagerFactory("JPA_MARIADB");
    }

    public boolean addAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Account findAccountById(String accountId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Account.class, accountId);
    }

    public List<Account> findAllAccount() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Account a", Account.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateAccount(Account account) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAccount(String accountId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Account account = em.find(Account.class, accountId);
            if (account != null) {
                em.remove(account);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
