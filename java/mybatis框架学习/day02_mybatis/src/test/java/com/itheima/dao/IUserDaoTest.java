package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


import java.util.Date;
import java.util.List;


public class IUserDaoTest {
    /**
     * 初始化方法
     */
    private InputStream in;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
    }
    /**
     * 结束方法
     */
    @After
    public void destory() throws IOException {
        in.close();
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     * 查询所有
     * @throws IOException
     */
    @Test
    public void findAlltest() throws IOException {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = userDao.findAll();
        for(User u:users){
            System.out.println("u = " + u);
        }
    }
    /**
     * 插入
     */
    @Test
    public void insertUserTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setAddress("湖北潜江");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("大哥");
        userDao.insert(user);
        System.out.println("user = " + user);
    }
    /**
     * 更新
     */
    @Test
    public void updateUserTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("pengzihao");
        user.setAddress("qianjiang");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setId(41);
        userDao.update(user);
    }
    /**
     * 根据id删除用户
     */
    @Test
    public void deleteUserTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.deleteUser(41);
    }
    /**
     * 根据id查询用户
     */
    @Test
    public void queryUserTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User u = userDao.QueryById(42);
        System.out.println("u = " + u);
    }
    /**
     * 根据名称模糊查询
     */
    @Test
    public void QueryByNameTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User> userList = userDao.QueryByName("%王%");
        System.out.println("userList = " + userList);
    }
    /**
     * 查询总用户数
     */
    @Test
    public void QueryTotalTest(){
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        int total = userDao.QueryTotal();
        System.out.println("total = " + total);
    }

}
