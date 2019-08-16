package com.itheima.Dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有操作
     */
    List<User> findAll();
}
