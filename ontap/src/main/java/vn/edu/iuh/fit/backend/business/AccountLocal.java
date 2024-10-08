package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Local;
import vn.edu.iuh.fit.backend.data.entities.Account;

@Local
public interface AccountLocal {
    void save(Account account);
}
