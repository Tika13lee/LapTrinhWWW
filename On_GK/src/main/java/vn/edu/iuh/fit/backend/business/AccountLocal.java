package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Local;
import vn.edu.iuh.fit.backend.data.entities.Account;

import java.util.List;

@Local
public interface AccountLocal {
    boolean addAccount(Account account);
    List<Account> getAllAccount();
    boolean deleteAccount(int id);
    boolean updateAccount(Account account);
    List<Account> getByUsername(String us);
    List<Account> findByBalance(int min, int max);
}
