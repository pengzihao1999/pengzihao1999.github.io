package com.itheima.domain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.List;

/** 创建对象注解
 * 一.用来声明JavaBean对象的注解有四个 对应于配置文件中的Bean标签
 * 1.@Component   都可以使用
 * 2.@Controller  最好在表现层
   3.@Service     最好在业务层
   4.@Repository  最好在持久层
 其中四个都可以声明JavaBean对象，当扫描对应包下的注解时，会将被这四个注解注解的类，创建对象，并添加到Spring的容器中
    Value：声明在容器中的key
 */

/** 二。数据注入注解
 * AutoWired注解
 * AutoWired:当Spring容器中有与声明在属性上的数据类型相同的对象，会自动注入
 * 出现位置：可以是变量上，可以是方法上
 * set方法不是必须的
 * AutoWired注解的执行流程
 * 1.比较容器中对象的数据类型和要注入的属性的数据类型
 * 2.如果容器中只有一个对象类型与注入对象类型相同，则将该对象注入
 * 3.如果有多个相同，如果不指定是哪一个对象要被注入，就会报错
 */

/** 数据注入注解
 * @Qualifier:根据存储在Spring容器中的名称进行注入(需配合AutoWired使用)
 * 1.它在类中不能单独注入，要配合AutoWired进行使用，否则注入对象为空，注入失败
 * 2.它可以在方法中单独使用，指定要注入对象的名称
 * value：注入对象在容器中的key
 *  @Resource:指定name="Spring容器的key值"进行注入对象
 *  以上两个只能注入JavaBean类的对象，无法注入基本数据类型的数据。且集合类型的数据只能通过xml进行注入
 *  @Value:能够注入基本类型数据，通过Spring的El表达式来注入
 *  例如  @Value("#{wang}")
            private String username;
    当创建对象时，就会给username属性注入wang的值
 */

/** 三 生命周期注解
 * @Scope注解 指定生命周期
 * 默认是singleton单例
 * 当指定为prototype为多例
 * 单例的声明周期：
 *  1.出生，容器创建时创建
 *  2.存活，容器存在对象存在
 *  3.死亡，容器销毁对象销毁
 *  与容器同寿
 *  多例的生命周期:
 *  1.出生，动态的创建，按需创建
 *  2.存活，对象工作时存活(引用不为空)
 *  3.死亡, 引用为空由JVM自动进行垃圾清理，Spring不管垃圾清理
 */
@Scope("prototype")
@Repository("User")
public class User {
    @Value("#{21234}")
    private String username;
    private String password;
    private List<String> userlist;
    @Resource(name="account1")
    private Accounts account;
    public User() {
    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userlist=" + userlist +
                ", account=" + account +
                '}';
    }
}
