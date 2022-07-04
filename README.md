## Spring
Spring是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的框架

## Spring框架七大模块
![在这里插入图片描述](image/spring-frame.png)

#### 1. 容器模块（spring core）
这是Spring框架最基础的部分，它提供了依赖注入（DependencyInjection）特征来实现容器对Bean的管理。核心容器的主要组件是 BeanFactory，BeanFactory是工厂模式的一个实现，是任何Spring应用的核心。它使用IoC将应用配置和依赖从实际的应用代码中分离出来

#### 2. 应用上下文模块（spring context）
核心模块的BeanFactory使Spring成为一个容器，而上下文模块使它成为一个框架。这个模块扩展了BeanFactory的概念，增加了对国际化（I18N）消息、事件传播、验证的支持
这个模块提供了许多企业服务，例如电子邮件、JNDI访问、EJB集成、远程以及时序调度（scheduling）服务。也包括了对模版框架例如Velocity和FreeMarker集成的支持
#### 3. AOP模块（spring aop）
Spring在它的AOP模块中提供了对面向切面编程的丰富支持，Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖组件，就可以将声明性事务管理集成到应用程序中，可以自定义拦截器、切点、日志等操作

#### 4. JDBC抽象和DAO模块（spring dao）
提供了一个JDBC的抽象层和异常层次结构，消除了烦琐的JDBC编码和数据库厂商特有的错误代码解析， 用于简化JDBC

#### 5. 对象/关系映射集成模块（spring orm）
Spring提供了ORM模块。Spring并不试图实现它自己的ORM解决方案，而是为几种流行的ORM框架提供了集成方案，包括Hibernate、JDO和iBATIS SQL映射，这些都遵从 Spring 的通用事务和 DAO 异常层次结构

#### 6. Web模块（spring web）
Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文，提供了Spring和其它Web框架的集成，比如Struts、WebWork。还提供了一些面向服务支持，例如：实现文件上传的multipart请求

#### 7. MVC模块（spring mvc）
Spring为构建Web应用提供了一个功能全面的MVC框架。虽然Spring可以很容易地与其它MVC框架集成，例如Struts，但Spring的MVC框架使用IoC对控制逻辑和业务对象提供了完全的分离

## Spring框架中的三大核心思想
DI(依赖注入),IOC(控制反转),AOP(面向切面编程)

#### IOC本质
控制反转IoC,是一种设计思想，DI是实现IoC的一种方法。没有IoC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码再程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方。

控制反转是一种通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方式是依赖注入（Dependency Injection,DI）。

## Spring 三种装配方式
 1. 在xml中显示的配置 

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="address" class="com.release.pojo.Address">
        <property name="address" value="济南"/>
    </bean>
    
</beans>

```

```java
 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
 Address address = (Address) context.getBean("address");
 System.out.println(address .toString());
```

 2. 在java中显示配置
 

```java
//这个也会Spring容器托管，注册到容器中，因为他本来就是一个@Component
//@Configuration代表这是一个配置类，就和我们之前看的beans.xml
@Configuration
@ComponentScan("com.release.pojo")
public class ReleaseConfig {

    //注册一个bean,就相当于我们之前写的一个bean标签
    //这个方法的名字，就相当于bean标签中的id属性
    //这个方法的返回值，就相当于bean标签中的class属性
    @Bean
    public User getUser() {
        return new User();//就是返回要注入bean的对象
    }
}
```

```java
@Component
public class User {

    @Value("张三")
    public String name;

}
```

```java
 //如果完全使用了配置类方式去做，我们就只能通过AnnotationConfig上下文来获取容器，通过配置类的class对象加载
 ApplicationContext context = new AnnotationConfigApplicationContext(ReleaseConfig.class);
 User user = context.getBean("getUser", User.class);
 System.out.println(user.name);
```

 

 3. 隐式的自动装配bean【重要】
 

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="cat" class="com.release.pojo.Cat"/>
    <bean id="dogh" class="com.release.pojo.Dog"/>


    <!--
        byName:会自动在容器上下文中查找，和自己对象set方法后面的值对应的bean id
        byType:会自动在容器上下文中查找，和自己对象属性类型相同的bean
    -->
    <bean id="people" class="com.release.pojo.People" autowire="byType">
        <property name="name" value="release"/>
    </bean>
</beans>
```

```java
  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
  People people = context.getBean("people", People.class);
  people.getCat().shout();
  people.getDog().shout();
```

 ## @Resource和@Autowired的区别
 - 都是用来自动装配的，都可以放在属性字段上
 - @Autowired通过byType的方式实现，而且必须要求这个对象存在
 - @Resource默认通过byname的方式实现，如果找不到名字，则通过byType实现，如果两个都找不到的情况下，就报错
 - 执行顺序不同：@Autowired通过byType的方式实现。@Resource默认通过byname 的方式实现。

## 注解说明
- @Autowired：自动装配通过类型，名字
   如果@Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
- @Nullable：字段标记了这个注解，说明这个字段可以为null
- @Resource：自动装配通过名字，类型
- @Component：组件，放在类上，说明这个类被Spring管理了，即使bean

## Aop在Spring中的作用
提供声明式事务；允许用户自定义切面

- 横切关注点：跨越应用程序多个模块的方法或功能。如：日志、安全、缓存、事务等....
- 切面（ASPECT）：横切关注点被模块化的特殊对象。即，它是一个类
- 通知（Advice）：切面必须要完成的工作。即，它是类中的一个方法
- 目标（Target）：被通知对象。
- 代理（Proxy）：向目标对象应用通知之后创建的对象
- 切入点（PointCut）：切面通知执行的“地点”的定义
- 连接点（joinPoint）：与切入点匹配的执行点

使用AOP，需要导入一个依赖包

```xml
    <dependencies>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.9.1</version>
        </dependency>
    </dependencies>
```

1. 方式一：使用原生Spring API接口【主要SpringAPI接口实现】
```xml
    <!--配置aop:需要导入aop的约束-->
    <aop:config>
        <!--切入点：expression：表达式，execution(要执行的位置！****)-->
        <aop:pointcut id="pointcut" expression="execution(* com.release.service.UserServiceImpl.*(..))"/>
        <aop:pointcut id="pointcut2" expression="execution(* com.release.service.UserServiceImpl.*(..))"/>
        <aop:pointcut id="pointcut3" expression="execution(* com.release.service.UserServiceImpl.*(..))"/>

        <!--执行环绕增加-->
        <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
        <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>

    </aop:config>
```
2. 方式二：自定义来实现AOP【主要是切面定义】

```xml
    <bean id="diy" class="com.release.diy.DiyPointCut"/>
    <aop:config>
        <!--自定义切入面，ref要引用的类-->
        <aop:aspect ref="diy">
            <!--切入点-->
            <aop:pointcut id="point" expression="execution(* com.release.service.UserServiceImpl.*(..))"/>
            <!--通知-->
            <aop:before method="before" pointcut-ref="point"/>
            <aop:after method="after" pointcut-ref="point"/>
        </aop:aspect>
    </aop:config>
```
 3. 使用注解实现
 

```xml
    <!--方式三：注解实现-->
    <bean id="annotationPointCut" class="com.release.diy.AnnotationPointCut"/>
    <!--开启注解支持-->
    <aop:aspectj-autoproxy/>
```

```java
@Aspect //标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.release.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("==================方法执行前====================");
    }

    @After("execution(* com.release.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("==================方法执行后====================");
    }

    /**
     * 在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
     */
    @Around("execution(* com.release.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("==================环绕前====================");

        //执行方法
        Object proceed = jp.proceed();

        System.out.println("==================环绕后====================");
    }
}
```
## Spring整合MyBatis
核心配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--DataSource:使用Spring的数据源替换Mybatis的配置 c3po dbcp druid-->
    <!--我们这里使用Spring提供的JDBC-->
    <bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url"
                  value="jdbc:mysql://localhost:3306/DB01?useUnicode=true&amp;characterEncoding=utf8&amp;useSSL=true&amp;serverTimezone=UTC"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </bean>

    <!--SqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="datasource"/>
        <!--绑定Mybatis配置文件-->
        <property name="mapperLocations" value="classpath:mapper/*.xml"/>
    </bean>

    <!--SqlSessionTemplate:就是我们使用的sqlSession-->
    <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
        <constructor-arg index="0" ref="sqlSessionFactory"/>
    </bean>

    <bean id="detpMapper" class="com.release.mapper.DeptMapperImpl">
        <property name="sqlSessionTemplate" ref="sqlSession"/>
    </bean>

    <bean id="detpMapper2" class="com.release.mapper.DeptMapperImpl2">
        <property name="sqlSessionTemplate" ref="sqlSession"/>
    </bean>
</beans>
```

## 声明式事务
事务ACID原则：
 - 原子性
 - 一致性
 - 隔离性
 - 持久性

```xml
    <!--1.创建事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="datasource"/>
    </bean>

    <!--2.结合AOP实现事务的织入-->
    <!--配置事务的类-->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <!--给哪些方法配置事务-->
        <!--配置事务的传播特性： new propagation-->
        <tx:attributes>
<!--            <tx:method name="add" propagation="REQUIRED"/>-->
<!--            <tx:method name="delete" propagation="REQUIRED"/>-->
<!--            <tx:method name="update" propagation="REQUIRED"/>-->
<!--            <tx:method name="query" read-only="true"/>-->
            <tx:method name="*" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>

    <!--3.配置事务切入-->
    <aop:config>
        <aop:pointcut id="txPointCut" expression="execution(* com.release.mapper.*.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
    </aop:config>
```
