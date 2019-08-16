package com.itheima.Dao;

import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

public class AccountDao implements IAccountDao {
    //需要注入queryRunner对象 并带有DataSource
    private QueryRunner queryRunner = null;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAll() {
        List<Account> accounts = null;
        try {
          accounts = queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public Account findAccountByID(Account account) {
        Account account1 = null;
        try {
            account1 = queryRunner.query("select * from account where id = ? ",new BeanHandler<Account>(Account.class),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }return account1;
    }

    public void deleteAccount(Account account) {
        try {
            queryRunner.update("delete from account where id = ?",account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name = ?,money = ?",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
