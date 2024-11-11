package vn.edu.iuh.fit.demo1.backend.business;

import jakarta.ejb.Local;
import vn.edu.iuh.fit.demo1.backend.data.entities.Account;

import java.util.List;

@Local
public interface AccountLocal {
    void save(Account account);
    List<Account> findAll();
    List<Account> findByUsername(String username);
    Account findById(String id);
    boolean delete(String id);
}
