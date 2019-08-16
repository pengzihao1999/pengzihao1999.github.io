package com.itheima.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 配置信息有关 注解
 * @Configuration
 * 作用：指定当前类是一个配置类
 *
 * @ComponentScan
 * 作用:指定在初始化配置时，需要扫描哪些包。
 * 与 <context:component-scan base-package="com.itheima"></context:component-scan>作用相同
 *
 * @import注解
 * 作用：可以直接导入分配置类，分配置类不需要再指定注解了
 * 属性：value：指定其他配置类的字节码，当我们使用import的注解后，有import注解的就是父配置类，而导入的都是子配置类
 *
 * @PropertySource("classpath:相当于类路径下的的资源")
 * 作用:用来指定加载的资源
 * 然后就可以通过Spring的el表达式进行获取
 *
 * */

/**
 * 方法注入有关 注解
 * @Bean
 * 作用：把当前方法返回值对象注入到Spring容器中
 * Value指定注入对象的id
 * 默认是方法的名称
 * 当我们使用注解方法时，如果方法有参数，Spring框架会去查找是否有对应的Bean对象
 * 查找的方式和@Autowired一致
 * 即：数据类型相同且容器中只有一个查找成功，否则失败
 * 如果有多个，需要指定在容器中的id 通过@Qualifier注解的id名称来进行查找
 */

@ComponentScan("com.itheima")
@Configuration
public class MapConfig {


}
