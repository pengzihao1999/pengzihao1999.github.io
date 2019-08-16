package Spring.Ino;

import com.itheima.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAno {
    /**
     * 测试类，修改day1xml的配置方式为注解配置方式
     */
    /**
     *
     *  1.指定扫描的包(xml方式)
     *  2.在对应的包中进行扫描被Spring注解的类和方法
     *  3.在容器中创建对象，有唯一的标识可以在容器中查找出该对象
     */
    @Test
    public void test1(){
        /*
            用注解来创建User对象
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringMapConfig");
        User user = ac.getBean("User", User.class);
        System.out.println("user = " + user);
    }
    @Test
    public void test2(){
        /*
            用注解来创建User对象
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringMapConfig");
        User user1 = ac.getBean("User", User.class);
        User user2 = ac.getBean("User", User.class);
        System.out.println("user1 = " + user1);
        System.out.println(user1==user2);
    }

}
