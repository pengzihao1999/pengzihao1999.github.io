package Spring.xml;

import com.itheima.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testxml {
    /**
     * 测试不带注解进行创建对象
     */
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringMapConfig");
        User user = ac.getBean("User", User.class);
        System.out.println("user = " + user);
    }
    /**
     * 测试set方式注入
     */
    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringMapConfig");
        User user = ac.getBean("User2",User.class);
        System.out.println("user = " + user);
    }
}
