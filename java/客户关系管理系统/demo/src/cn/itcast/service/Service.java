package cn.itcast.service;

import cn.itcast.dao.PageBean;
import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public interface Service {
    public List<User> findAll();

    public User Login(User user);

    void addUser(User user);

    void update(User user);

   User findUser(User user);

    void deleteUser(String id);

    PageBean<User> fingPageByUser(String currentpage, String rows, Map<String, String[]> condition);
}
