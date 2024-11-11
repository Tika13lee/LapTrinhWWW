package vn.edu.iuh.fit.demo1.backend.business;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.demo1.backend.data.entities.Account;
import vn.edu.iuh.fit.demo1.backend.data.repositories.AccountRepository;

import java.util.List;

@Stateless
public class AccountBean implements AccountLocal{
    @Inject
    private AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account findById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public boolean delete(String id) {
        return accountRepository.delete(id);
    }
}
