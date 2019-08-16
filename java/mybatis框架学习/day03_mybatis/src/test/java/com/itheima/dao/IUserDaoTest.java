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
    /**
     * 根据包装对象传入的条件进行动态sql的编写查询出集合对象
     */
    @Test
    public void QueryUserByVoTest(){
        QueryVo q = new QueryVo();
        User u = new User();
        u.setSex("女");
        u.setUsername("%王%");
        q.setUser(u);
        QueryVoDao vo = sqlSession.getMapper(QueryVoDao.class);
        List<User> users = vo.QueryUserByVo(q);
        for(User us:users){
            System.out.println("u = " + us);
        }
    }
    /**
     * 根据包装对象提供的list集合进行查询
     */
//    @Test
//    public void QueryUserByListTest(){
//        QueryVo queryVo = new QueryVo();
//        List list = new ArrayList();
//        list.add(41);
//        list.add(42);
//        list.add(45);
//        queryVo.setIntegers(list);
//        QueryVoDao dao = sqlSession.getMapper(QueryVoDao.class);
//        List<User> users = dao.QueryUserByList(queryVo);
//        for(User u:users){
//            System.out.println("u = " + u);
//        }
//    }
    /**
     * 多表查询之一对一查询
     * 我们分析账户和用户表之间的关系
     * 一个用户可以拥有多个账户
     * 一个账户只能被一个用户拥有
     * 用户和账户之间是一对多关系
     * 账户和用户之间是一对一关系
     */
    /**
     * 查询一对一关系及查询每个账户时要带有用户信息
     * 解决方式一:新建一个实体类，实体类包含用户和账户的实体
     * 通常不这么使用
     */
    @Test
    public void test1(){
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<AccountWithUser> awl = dao.selectAccount();
        for(AccountWithUser u:awl){
            System.out.println("u = " + u);
        }
    }
    /**
     * 解决方式二 Account对象中持有User对象的引用，把查询出来的结果直接封装到User对象中
     * 一对一关系的常用解决办法，在对象中持有另一个对象的引用
     */
    @Test
    public void test2(){
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = dao.selectAccountEx();
        for(Account a:accounts){
            System.out.println("a = " + a);
        }
    }
    /**
     * 查询用户信息，带有账户信息
     * 查询一对多关系，查询用户信息，对应多个账户
     * 一对多关系的解决办法,在对象中持有另一个对象引用的集合
     */
    @Test
    public void test3(){
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        List<User> users = dao.queryUserWithAccounts();
        for(User u:users){
            System.out.println("u = " + u);
        }
    }
    /**
     * mybatis中的多对多关系查询
     * -其实是双向的一对多关系
     * -多对多关系通常通过提取两个表中的主键，新建一个表，让两个表的主键作为当前表的外键即可
     * 实现步骤
     * 1.创建对应的数据库表的实体类
     * 2.创建实体类的Dao层接口
     * 3.创建实体类的映射配置文件
     * 4.编写sql语句
     * 5.测试
     */
    /**
     * 数据库中有三个表用户角色，用户表，角色表
     * 实现功能一：查询用户信息，带有该用户的角色信息
     */
    @Test
    public void  many2manyTest1(){
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        List<User> users = dao.m2m1();
        for (User u:users){
            System.out.println("u = " + u);
        }
    }
    @Test
    public void many2manyTest2(){
        RoleDao dao = sqlSession.getMapper(RoleDao.class);
        List<Role> roleList = dao.m2m2();
        for(Role r:roleList){
            System.out.println("r = " + r);
        }
    }

}
