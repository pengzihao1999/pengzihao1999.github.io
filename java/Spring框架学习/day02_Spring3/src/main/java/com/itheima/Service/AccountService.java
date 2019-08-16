package com.itheima.Service;

import com.itheima.Dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("AccountService")
public class AccountService {
    @Autowired
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
