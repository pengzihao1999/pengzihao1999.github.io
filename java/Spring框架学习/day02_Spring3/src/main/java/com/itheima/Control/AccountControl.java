package com.itheima.Control;

import com.itheima.Service.AccountService;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("AccountControl")
public class AccountControl {

    @Autowired
    private AccountService accountService = null;
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    public List<Account> findAll() {
        return accountService.findAll();
    }

    public Account findAccountByID(Account account) {
        return accountService.findAccountByID(account);
    }

    public void deleteAccount(Account account) {
        accountService.deleteAccount(account);
    }

    public void updateAccount(Account account) {
        accountService.updateAccount(account);
    }

    public void insertAccount(Account account) {
        accountService.insertAccount(account);
    }


}
