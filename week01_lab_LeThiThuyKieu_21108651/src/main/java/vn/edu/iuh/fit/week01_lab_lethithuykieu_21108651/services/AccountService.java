package vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.services;

import vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.entities.Account;
import vn.edu.iuh.fit.week01_lab_lethithuykieu_21108651.repositories.AccountRepository;

import java.util.List;

public class AccountService {
    private AccountRepository accountRepository = new AccountRepository();

    public boolean checkLogin(String username, String password){
        Account account = accountRepository.findAccountById(username);
        if(account != null){
            if(account.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public Account getAccountById(String username){
        return accountRepository.findAccountById(username);
    }

    public List<Account> getAllAccount(){
        return accountRepository.findAllAccount();
    }
}
