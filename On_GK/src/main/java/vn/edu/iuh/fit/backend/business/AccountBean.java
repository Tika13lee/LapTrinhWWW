package vn.edu.iuh.fit.backend.business;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.backend.data.entities.Account;
import vn.edu.iuh.fit.backend.data.repositories.AccountRepository;

import java.util.List;

@Stateless
public class AccountBean implements  AccountLocal{
    @Inject
    private AccountRepository accountRepository;

    @Override
    public boolean addAccount(Account account) {
        return accountRepository.saveAccount(account);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAllAccount();
    }

    @Override
    public boolean deleteAccount(int id) {
        return accountRepository.deleteAccount(id);
    }

    @Override
    public boolean updateAccount(Account account) {
        return accountRepository.updateAccount(account);
    }

    @Override
    public List<Account> getByUsername(String us) {
        return accountRepository.getByUsername(us);
    }

    @Override
    public List<Account> findByBalance(int min, int max) {
        return accountRepository.findByBalance(min, max);
    }
}
