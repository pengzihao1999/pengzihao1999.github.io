package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountWithUser;

import java.util.List;

public interface AccountDao {
    List<AccountWithUser> selectAccount();

    List<Account> selectAccountEx();
}
