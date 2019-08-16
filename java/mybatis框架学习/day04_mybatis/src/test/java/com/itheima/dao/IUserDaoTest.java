package com.itheima.dao;

import com.itheima.domain.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class IUserDaoTest {
    /**
     * 初始化方法
     */
    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 结束方法
     */
    @After
    public void destory() throws IOException {
        in.close();
    }
    /**
     * 查询所有用户，用户与账户是一对多关系，查询用户中包含所有的账户信息
     * 两张表连接查询，立即加载。
     */
    @Test
    public void test1(){
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        List<User> users  = dao.findAllByStep();
        for(User u:users){
            System.out.println("u = " + u);
        }
    }
    /**
     * 查询所有用户，用户与账户是一对多关系，查询用户中包含所有的账户信息
     * 分布查询，不实现懒加载
     * 1.首先先查询所有用户
     * 2.通过用户的id进行查询账户
     */
    @Test
    public void test2(){
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        List<User> users = dao.findAllByStep();
        User user = users.get(0);
        System.out.println("user.name = " + user.getUsername());
        System.out.println("我不是懒加载加载");
        System.out.println("user = " + user.getAccounts());
    }

    /**
     * 实现懒加载,修改主配置文件
     */
    @Test
    public void test3(){
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        List<User> users = dao.findAllByStep();
        User user = users.get(0);
        System.out.println("user.name = " + user.getUsername());
        System.out.println("我是懒加载加载");
        System.out.println("user = " + user.getAccounts());
    }

    /**
     * 查询账户信息，并带有User信息，一对一查询
     * 通常在一对多或多对一时，进行懒加载
     * 在一对一查询时，直接进行加载即可
     */
    @Test
    public void test4(){
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = dao.findAllByStep();
        Account account = accounts.get(0);
        System.out.println(account.getMoney());
        System.out.println("我是懒加载加载");
        System.out.println(account.getUser());
    }
    /**
     * 证明mybatis的一级缓存
     * 一级缓存是sqlSession的缓存
     */
    @Test
    public void test5(){
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        User u1 = dao.findUserByID(41);
        User u2 = dao.findUserByID(41);
        System.out.println(u1==u2);
    }
    /**
     * 当调用sqlSession的close方法commit方法，或者进行update ,insert ,delete操作
     * 会清除一级缓存
//     */
//    @Test
//    public void test6(){
//        SqlSession sqlSession1 = sqlSessionFactory.openSession();
//        IUserDao dao = sqlSession1.getMapper(IUserDao.class);
//        User u1 = dao.findUserByID(42);
//        sqlSession1.close();
//        SqlSession sqlSession2 = sqlSessionFactory.openSession();
//        IUserDao dao1 =sqlSession2.getMapper(IUserDao.class);
//        User u2 = dao1.findUserByID(43);
//        System.out.println(u1==u2);
//    }
    /**
     * 测试调用update方法清除一级缓存
     */
    @Test
    public void test7(){

        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        User u1 = dao.findUserByID(42);
        System.out.println("u1 = " + u1);
        System.out.println("u1的hashcode"+u1.hashCode());

       //调用update方法

        u1.setId(42);
        u1.setUsername("dad");
        u1.setAddress("北京市区");
        dao.updateByID(42);
        sqlSession.commit();

        User u2 = dao.findUserByID(42);
        System.out.println("u2 = " + u2);
        System.out.println("u2的hashcode"+u2.hashCode());
        System.out.println(u1==u2);
    }
    /**
     * 测试mybatis的二级缓存
     * mybatis的二级缓存:
     * 通过sqlSessionFactory对象创建的sqlSession都共享一片工作区域
     */
    @Test
    public void test8(){
       SqlSession session1 =  sqlSessionFactory.openSession();
       SqlSession session2 = sqlSessionFactory.openSession();
       IUserDao dao1 = session1.getMapper(IUserDao.class);

       User u1 = dao1.findUserByID(42);
       System.out.println("u1 = " + u1);
       //关闭session1的一级缓存
        //一级缓存和二级缓存同时存在的时候优先使用二级缓存
//       session1.close();
//       System.out.println("不关闭一级缓存查询");
//       User u3 =  dao1.findUserByID(42);
//        System.out.println("u3 = " + u3);
       IUserDao dao2 = session2.getMapper(IUserDao.class);
       User u2 = dao2.findUserByID(42);
       System.out.println("u2 = " + u2);
       System.out.println(u1==u2);
    }
}
