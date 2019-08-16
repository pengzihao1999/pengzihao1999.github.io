package com.itheima.Dao;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountDao {
    public List<Account> findAll();
    public Account findAccountByID(Account account);

    public void deleteAccount(Account account);

    public void updateAccount(Account account);

    public void insertAccount(Account account);
}
