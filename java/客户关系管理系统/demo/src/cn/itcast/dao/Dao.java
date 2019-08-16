package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public interface Dao {
    public List<User> findAll();



    public User Login(User user);

    void addUser(User user);

    void update(User user);

    User findUser(User user);

    void deleteUser(String id);

    int findcount(Map<String, String[]> condition);

    List<User> findUserList(int a, int b, Map<String, String[]> condition);
}
