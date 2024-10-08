package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.backend.data.entities.Account;
import vn.edu.iuh.fit.backend.data.repositories.AccountRepository;

@Stateless
public class AccountBean implements AccountLocal {
    @Inject
    private AccountRepository accountRepository;
    @Override
    public void save(Account account) {
         accountRepository.save(account);
    }
}
