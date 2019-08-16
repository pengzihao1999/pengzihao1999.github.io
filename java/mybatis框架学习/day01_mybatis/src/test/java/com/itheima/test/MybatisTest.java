package com.itheima.test;



import com.itheima.Dao.UserDao;
import com.itheima.domain.User;
import com.itheima.mybaties.buider.SqlSessionFactoryBuilder;
import com.itheima.mybaties.factory.SqlSessionFactory;
import com.itheima.mybaties.io.Resources;
import com.itheima.mybaties.session.SqlSession;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建sqlsessionFactory工厂
        //可以看到SqlSession是一个接口，必然有一个实现类实现该接口
        SqlSessionFactory factory = null;
        //sqlsessionFactory构建者生成SqlSessionFactory对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        //3.使用工厂生产sqlsession SqlSession是一个接口,通过工厂模式返回一个实例
        SqlSession sqlSession = factory.openSession();
        //4.使用sqlsession创建dao接口的代理对象
        //通过该对象的getMapper方法,
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> userList = userDao.findAll();
        for(User u:userList){
            System.out.println("u = " + u);
        }
        //6.释放资源
        sqlSession.close();

    }
}
