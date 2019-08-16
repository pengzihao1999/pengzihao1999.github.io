package Ano;

import com.itheima.Control.AccountControl;
import com.itheima.conf.MapConfig;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void findAll(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(MapConfig.class);
        AccountControl accountControl = ac.getBean("AccountControl", AccountControl.class);
        List<Account> accounts = accountControl.findAll();
        System.out.println("accounts = " + accounts);
    }
    @Test
    public void delete(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(MapConfig.class);
        Account account = new Account();
        account.setId(3);
        AccountControl accountControl = ac.getBean("AccountControl", AccountControl.class);
        accountControl.deleteAccount(account);
    }
    @Test
    public void insert(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(MapConfig.class);
        Account account = new Account();
        account.setName("insert one ");
        AccountControl accountControl = ac.getBean("AccountControl", AccountControl.class);
        accountControl.insertAccount(account);
    }
    @Test
    public void update(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(MapConfig.class);
        Account account = new Account();
        account.setId(3);
        account.setName("pengzihao");
        AccountControl accountControl = ac.getBean("AccountControl", AccountControl.class);
        accountControl.updateAccount(account);
    }
    /**
     * 测试queryrunner是否多例
     */
    @Test
    public void testQuery(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(MapConfig.class);
        QueryRunner queryRunner1 = ac.getBean("queryRunner", QueryRunner.class);
        QueryRunner queryRunner2 = ac.getBean("queryRunner", QueryRunner.class);
        System.out.println(queryRunner1==queryRunner2);
    }
}
