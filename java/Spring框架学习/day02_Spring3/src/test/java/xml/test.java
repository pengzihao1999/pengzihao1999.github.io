package xml;

import com.itheima.Control.AccountControl;
import com.itheima.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void findAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("map.xml");
        AccountControl accountControl = ac.getBean("AccountControl", AccountControl.class);
        List<Account> accounts = accountControl.findAll();
        System.out.println("accounts = " + accounts);
    }
    @Test
    public void delete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("map.xml");
        Account account = new Account();
        account.setId(3);
        AccountControl accountControl = ac.getBean("AccountControl", AccountControl.class);
        accountControl.deleteAccount(account);
    }
    @Test
    public void insert(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("map.xml");
        Account account = new Account();
        account.setId(2);
        AccountControl accountControl = ac.getBean("AccountControl", AccountControl.class);
        accountControl.insertAccount(account);
    }
    @Test
    public void update(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("map.xml");
        Account account = new Account();
        account.setId(3);
        account.setName("pengzihao");
        AccountControl accountControl = ac.getBean("AccountControl", AccountControl.class);
        accountControl.updateAccount(account);
    }
}
