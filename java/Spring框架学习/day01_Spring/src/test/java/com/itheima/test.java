package com.itheima;

import com.itheima.Service.UserService;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    /**
     * 通过SpringIoc创建作用域为单例对象，scope="singleton"
     *  <bean id="UserService" class="com.itheima.Service.UserService" scope="singleton"></bean>
     * 单例对象是立即加载的，在加载配置文件时，创建容器的同时就创建单例对象
     * 单例对象的生命周期:
     * 1.创建时期：容器创建时就进行创建
     * 2.作用时期: 只要容器在，对象就一直在
     * 3.销毁时期：容器销毁，对象销毁
     */
    @Test
    public void test1(){
        ApplicationContext map = new ClassPathXmlApplicationContext("map.xml");
        UserService service1 = map.getBean("UserService", UserService.class);
        UserService service2 = map.getBean("UserService", UserService.class);
        System.out.println("service1 = " + service1);
        System.out.println("service2 = " + service2);
        System.out.println(service1==service2);
    }
    /**
     * 通过SpringIoc创建多例对象 scope="prototype"
     * <bean id="UserDao" class="com.itheima.dao.UserDao" scope="prototype" init-method="init" destroy-method="destory"></bean>
     * 多例对象是延迟加载的，即什么时候用，什么时候加载
     * 多例对象的生命周期
     * 1.创建时期:什么时候用，什么时候加载
     * 2.作用时期：对象在使用中
     * 3.销毁时期：失去对象的引用后，通过gc进行垃圾清理
     */
    @Test
    public void test2(){
        ApplicationContext map = new ClassPathXmlApplicationContext("map.xml");
        UserDao userDao1 = map.getBean("UserDao", UserDao.class);
        UserDao userDao2 = map.getBean("UserDao",UserDao.class);
        System.out.println("userDao1 = " + userDao1);
        System.out.println("userDao2 = " + userDao2);
        System.out.println(userDao1==userDao2);
    }

    /**
     * 测试实例化对象的三种方式
     * 1.通过无参构造函数创建
     * 2.通过工厂的成员方法进行创建(实例工厂)
     * 3.通过工厂的静态方法创建(静态工厂)
     */
    /**
     * 通过无参构造函数进行创建
     */
    @Test
    public void test3(){
        ApplicationContext map = new ClassPathXmlApplicationContext("map.xml");
        UserDao userDao1 = map.getBean("UserDao", UserDao.class);
    }
    /**
     * 通过实例工厂进行创建
     * 实例工厂创建过程，先实例化工厂，在调用方法创建对象
     *
     * <bean id="BeanFactory" class="com.itheima.Factory.BeanFactory" ></bean>
     * <bean id="UserDaofactory" class="com.itheima.dao.UserDao"
     * factory-bean="BeanFactory" factory-method="getUserDao"></bean>
     */
    @Test
    public void test4(){
        ApplicationContext map = new ClassPathXmlApplicationContext("map.xml");
        UserDao userDao = map.getBean("UserDaofactory",UserDao.class);
    }
    /**
     * 通过静态工厂进行创建
     * 静态工厂的创建,通过指定工厂的创建实例对象方法
     * <bean id="UserDaoSBFactory" class="com.itheima.Factory.StaticBeanFactory" factory-method="getUserDao">
     */
    @Test
    public void test5(){
        ApplicationContext map = new ClassPathXmlApplicationContext("map.xml");
        UserDao userDao = map.getBean("UserDaoSBFactory",UserDao.class);
    }
    /**
     * 依赖注入的几种方式
     * 1.有参构造函数注入
     * 2.set方法注入
     * 3.集合注入
     */
    /**
     * 1.有参构造函数注入
     * <bean id="User" class="com.itheima.domain.User">
     <constructor-arg name="username" value="pzh"></constructor-arg>
     <constructor-arg name="password" value="1999"></constructor-arg>
     </bean>
     * 用到了construtor标签 name是有参构造函数的形参，value是要填充的值
     *
     */
    @Test
    public void test6(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("map.xml");
        User user = applicationContext.getBean("User", User.class);
        System.out.println("user = " + user);
    }
    /**
     * 2.set方式注入
     * <bean id="User" class="com.itheima.domain.User">
        <property name="username" value="pzh"></property>
        <property name="password" value="123"></property>
       </bean>
     */
    @Test
    public void test7(){
        ApplicationContext app = new ClassPathXmlApplicationContext("map.xml");
        User user = app.getBean("User", User.class);
        System.out.println("user = " + user);
    }
    /**
     * 3.集合注入
     *     <bean id="User" class="com.itheima.domain.User">
               <property name="username" value="pzh"></property>
                 <property name="password" value="123"></property>
                 <property name="userlist">
                 <list>
                 <value>aaa</value>
                 <value>bbb</value>
                 <value>ccc</value>
                 </list>
               </property>
          </bean>
     */
    @Test
    public void test8(){
        ApplicationContext app = new ClassPathXmlApplicationContext("map.xml");
        User user = app.getBean("User", User.class);
        System.out.println("user = " + user);
    }
    /**
     * 通过set注入对象并调用dao层的方法
     * <bean id="UserService" class="com.itheima.Service.UserService">
            <property name="userdao" ref="UserDao"></property>
       </bean>
       <bean id="UserDao" class="com.itheima.dao.UserDao"></bean>
        ref指向的id 通过id在IOC容器中拿到对应的对象
     */
    @Test
    public void test9(){
        ApplicationContext app = new ClassPathXmlApplicationContext("map.xml");
        UserService userService = app.getBean("UserService", UserService.class);
        userService.saveAccount();
        System.out.println("userService = " + userService);
    }
}
