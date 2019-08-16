package com.itheima.Service;

import com.itheima.Dao.AccountDao;
import com.itheima.domain.Account;

import java.util.List;

public class AccountService {
    private AccountDao accountDao = null;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findAccountByID(Account account) {
        return accountDao.findAccountByID(account);
    }

    public void deleteAccount(Account account) {
        accountDao.deleteAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }
}
