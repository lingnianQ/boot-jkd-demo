# Springboot

> 1. servlet技术 - 属于javaee技术体系 - 传统的web技术 - 写法比较繁琐
>
> 2. springmvc框架 - ssm框架 - spring+springmvc+mybatis
>
>    springmvc框架基于servlet技术,对servlet技术封装
>
> 3. springboot框架
>
>    比springmvc的配置更加精简.

> 使用springboot快速搭建微服务项目.
>
> **微服务 + 分布式 + 集群**

## 环境准备

> 1. jdk - JAVA_HOME
>
> 2. **maven**或者**gradle**
>
>    项目的构建工具以及项目的依赖[传统项目中的那个jar包]管理工具

## 安装maven

> 1. 官网下载 - https://maven.apache.org/download.cgi
>
> 2. 环境变量的配置
>
>    定位到系统变量 
>
>    2-1. 新建  变量名:MAVEN_HOME
>
>    2-2 		   变量值:/Users/admin/Documents/success/d/apache-maven-3.3.9 - maven解压的根目录
>
> 3. 找到Path - 编辑 - 新增
>
>    %MAVEN_HONE%\bin
>
> 4. 点击确定 - 关闭所有的窗口
>
> 5. 打开终端[cmd窗口],输入查看maven版本号的命令
>
>    ~~~cmd
>    mvn -v
>    ~~~

## 修改镜像

> 1. 在maven的解压的目录下新建一个目录repo
>
> 2. 进入用户主目录,查看是否存在**.m2目录**
>
>    ~~~xml
>    <?xml version="1.0" encoding="UTF-8"?>
>    <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
>              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>              xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
>      <localRepository>/Users/admin/Documents/success/d/apache-maven-3.3.9/repo</localRepository>      
>    	  <mirrors>
>    		   <mirror> 
>              <id>alimaven</id>
>              <name>aliyun maven</name> 
>              <url>http://maven.aliyun.com/nexus/content/groups/public/</url> 
>              <mirrorOf>central</mirrorOf> 
>    		  </mirror>
>      </mirrors>
>    </settings>
>    ~~~

# 搭建SpringBoot微服务工程

> Spring Web - web项目依赖的web启动启动器
>
> ~~~xml
> <groupId>tech.aistar</groupId>
> <artifactId>boot-jkd-demo</artifactId>
> <version>0.0.1-SNAPSHOT</version>
> ~~~

> pom的坐标

# 主配置文件的介绍

> 推荐使用yml文件 - yarn语法 - **要求极其严格.**
>
> 讲究的是"约定大于配置",一定是放在src/main/resources目录下,名称一定是application.yml

# 体验一下

> 1. 添加了一个lombok依赖
>
>    ~~~xml
>     <dependency>
>       <groupId>org.projectlombok</groupId>
>       <artifactId>lombok</artifactId>
>    </dependency>
>    ~~~
>
> 2. 定制后端统一返回的对象
>
>    ~~~java
>    package tech.aistar.model;
>    
>    import lombok.AllArgsConstructor;
>    import lombok.Data;
>    import lombok.NoArgsConstructor;
>    
>    import java.io.Serializable;
>    
>    /**
>     * 本类用来演示: 后端统一返回的对象
>     * 
>     * @author: success
>     * @date: 2021/10/30 10:28 上午
>     */
>    @Data
>    @AllArgsConstructor
>    @NoArgsConstructor
>    public class Result implements Serializable {
>        private String code;
>        
>        private String msg;
>        
>        private Object data;
>    }
>    ~~~
>
> 3. 编写HelloController控制器
>
>    ~~~java
>    package tech.aistar.controller;
>       
>    import org.springframework.web.bind.annotation.GetMapping;
>    import org.springframework.web.bind.annotation.PostMapping;
>    import org.springframework.web.bind.annotation.RequestMapping;
>    import org.springframework.web.bind.annotation.RestController;
>    import tech.aistar.model.Result;
>       
>    /**
>     * 本类用来演示:
>     *
>     * @author: success
>     * @date: 2021/10/30 10:32 上午
>     */
>    @RestController // 将方法的返回的结果自动转换成json格式的字符串
>    @RequestMapping("/hello") // 推荐模块名称命名的.
>    public class HelloController {
>        //post - 增加
>        //get - 查询
>        //delete - 删除
>        //put - 更新
>       
>        /**
>         * 接受get请求
>         * restful一种设计架构风格
>         * http://localhost:8081/boot/hello/test01
>         * @return
>         */
>        @GetMapping
>        public Result hello(){
>            return new Result("200","hello-get-体验",null);
>        }
>       
>        /**
>         * 只能接受post请求
>         * HTTP状态码 - 405
>         * 请求的方式和接受请求的方式不一致的时候
>         * @return
>         */
>        @PostMapping
>        public Result hello2(){
>            return new Result("200","hello-post-体验",null);
>        }
>    }
>       
>    ~~~
>
>    localhost:8081/hello



# Springboot整合mybatis

> 1. 导入依赖并且刷新
>
>    ~~~xml
>     <dependency>
>       <groupId>mysql</groupId>
>       <artifactId>mysql-connector-java</artifactId>
>       <exclusions>
>         <exclusion>
>           <groupId>com.google.protobuf</groupId>
>           <artifactId>protobuf-java</artifactId>
>         </exclusion>
>       </exclusions>
>    </dependency>
>    <!-- mybatis -->
>    <dependency>
>      <groupId>org.mybatis.spring.boot</groupId>
>      <artifactId>mybatis-spring-boot-starter</artifactId>
>      <version>2.2.0</version>
>    </dependency>
>    ~~~
>
> 2. application.yml
>
>    ~~~yml
>    server:
>      port: 8081
>      servlet:
>        context-path: /boot
>    mybatis:
>      type-aliases-package: tech.aistar.model
>      configuration:
>        log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
>        map-underscore-to-camel-case: true
>    spring:
>      datasource:
>        driver-class-name: com.mysql.cj.jdbc.Driver
>        username: root
>        password: root
>        url: jdbc:mysql://localhost:3306/jkds?useSSL=false
>    ~~~
>
> 3. 实体类
>
>    ~~~java
>    package tech.aistar.model;
>    
>    
>    import lombok.AllArgsConstructor;
>    import lombok.Data;
>    import lombok.NoArgsConstructor;
>    
>    import java.io.Serializable;
>    import java.util.Date;
>    @Data
>    @NoArgsConstructor
>    @AllArgsConstructor
>    public class User implements Serializable {
>    
>      private Integer id;
>      private String username;
>      private String password;
>      private Date birthday;
>      private Integer status;
>    }
>    ~~~
>
> 4. 编写mapper层 - UserMapper.java - 接口
>
>    ~~~java
>    package tech.aistar.mapper;
>    
>    import org.apache.catalina.User;
>    import org.apache.ibatis.annotations.Select;
>    
>    import java.util.List;
>    
>    /**
>     * 本类用来演示:
>     *
>     * @author: success
>     * @date: 2021/10/30 11:27 上午
>     */
>    public interface UserMapper {
>        
>        @Select("select * from t_user")
>        List<User> findAll();
>    }
>    
>    ~~~
>
> 5. 单元测试 src/test/java
>
>    单元测试的包名要和上面测试接口的包名保持一致
>
>    ~~~java
>    package tech.aistar.mapper;
>    
>    import org.junit.jupiter.api.Test;
>    import org.springframework.beans.factory.annotation.Autowired;
>    import org.springframework.boot.test.context.SpringBootTest;
>    
>    /**
>     * 本类用来演示:
>     *
>     * @author: success
>     * @date: 2021/10/30 11:29 上午
>     */
>    @SpringBootTest
>    public class UserMapperTest {
>        @Autowired
>        private UserMapper userMapper;
>    
>        @Test
>        public void testFindAll(){
>            userMapper.findAll().forEach(e-> System.out.println(e));
>        }
>    }
>    
>    ~~~
>
> 6. 主程序上添加扫包注解 - mapper动态代理
>
>    ~~~java
>    package tech.aistar;
>       
>    import org.mybatis.spring.annotation.MapperScan;
>    import org.springframework.boot.SpringApplication;
>    import org.springframework.boot.autoconfigure.SpringBootApplication;
>       
>    @SpringBootApplication
>    @MapperScan(basePackages = "tech.aistar.mapper")
>    public class BootJkdDemoApplication {
>       
>        public static void main(String[] args) {
>            SpringApplication.run(BootJkdDemoApplication.class, args);
>        }
>       
>    }
>    ~~~

# Springboot整合jsp

> Springboot虽然内置了tomcat,不支持jsp的解析
>
> ~~~xml
> <!--        jsp的解析引擎-->
> <dependency>
>   <groupId>org.apache.tomcat.embed</groupId>
>   <artifactId>tomcat-embed-jasper</artifactId>
> </dependency>
> ~~~
>
> 

> Springboot本身对jsp支持不是特别友好的.
>
> 1. src/main下新建一个目录webapp目录
>
>    就是用来存储前端资源的目录以及jsp文件.
>
> 2. src/main/webapp/WEB-INF - 是一个安全级别比较高的目录.
>
>    不能够直接通过浏览器进行直接的访问,必须是通过转发的方式才能访问.
>
>    **WEB-INF目录就是用来存放JSP文件的**
>
> 3. 拷贝一个web.xml - web项目的描述性文件
>
>    ~~~xml
>    <?xml version="1.0" encoding="UTF-8"?>
>    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
>             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
>             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
>             version="4.0">
>    </web-app>
>    ~~~

> 4. 设置webapp目录为web资源目录
>
>    File - Project Structure - Facets
>
>    4-1. 添加web.xml的位置
>
>    4-2. webapp的位置

# 返回的形式

> 1. 直接返回一个json字符串,使用到的是@RestController
>
>    ~~~java
>    @RestController = @Controller + @ResponseBody
>    ~~~
>
> 2. 转发或者重定向
>
>    2-1. 转发到页面/另外一个后台
>
>    2-2. 重定向到另外一个后台

## 转发到Jsp

~~~java
package tech.aistar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本类用来演示: 转发和重定向
 *
 * @author: success
 * @date: 2021/10/30 1:36 下午
 */
@Controller
//@RestController
@RequestMapping("/go")
public class ForwardAndRedirectController {

    /**
     * ajax请求过来,一般返回json数据出去
     * @return
     */
    @ResponseBody
    @GetMapping("/t1")
    public String hello(){
        return "ok";
    }

    /**
     * 非ajax请求过来,一般就是进行跳转
     * @return
     */
    @GetMapping("/t2")
    public String t2(){
        //把返回的数据当成视图的逻辑视图名.
        //return "/WEB-INF/hello.jsp";

        return "hello";
    }
}

~~~



# 配置前缀和后缀

~~~yml
server:
  port: 8081
  servlet:
    context-path: /boot
mybatis:
  type-aliases-package: tech.aistar.model
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    map-underscore-to-camel-case: true
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/jkds?useSSL=false  
  mvc:
    view:
      prefix: /WEB-INF/
      suffix: .jsp
~~~



# 登录任务实现

> 1. UserMapper.java
>
>    ~~~java
>    @Select("select * from t_user where username=#{username}")
>    User findByUsername(String username);
>    ~~~
>
> 2. IUserService.java
>
>    ~~~java
>    package tech.aistar.service;
>    
>    import tech.aistar.model.User;
>    
>    /**
>     * 本类用来演示: 用户的业务逻辑层
>     *
>     * @author: success
>     * @date: 2021/10/30 2:47 下午
>     */
>    public interface IUserService {
>    
>        /**
>         * 根据用户名查找用户
>         * @param username 一定是唯一的
>         * @return 单个user对象
>         */
>        User login(String username);
>    }
>    
>    ~~~
>
> 3. UserServiceImpl.java
>
>    ~~~java
>    package tech.aistar.service.impl;
>    
>    import org.springframework.beans.factory.annotation.Autowired;
>    import org.springframework.stereotype.Service;
>    import tech.aistar.mapper.UserMapper;
>    import tech.aistar.model.User;
>    import tech.aistar.service.IUserService;
>    
>    /**
>     * 本类用来演示:
>     *
>     * @author: success
>     * @date: 2021/10/30 2:48 下午
>     */
>    @Service // 让service层的类交给spring进行管理
>    public class UserServiceImpl implements IUserService {
>        
>        //service层调用Mapper层
>        //mapper层 - 和db进行交互的
>        //service层 - 调用mapper层,进行数据的业务逻辑处理
>        
>        @Autowired
>        private UserMapper userMapper;
>        
>        @Override
>        public User login(String username) {
>            return userMapper.findByUsername(username);
>        }
>    }
>    
>    ~~~
>
> 4. mapper接口和service都是需要单独进行测试的
>
>    ~~~java
>    package tech.aistar.service;
>    
>    import org.junit.jupiter.api.Test;
>    import org.springframework.beans.factory.annotation.Autowired;
>    import org.springframework.boot.test.context.SpringBootTest;
>    
>    /**
>     * 本类用来演示:
>     *
>     * @author: success
>     * @date: 2021/10/30 2:50 下午
>     */
>    @SpringBootTest
>    public class UserServiceTest {
>        @Autowired
>        private IUserService userService;
>    
>        @Test
>        public void testLogin(){
>            System.out.println(userService.login("admin"));
>        }
>    }
>    
>    ~~~
>
> 5. 前端ajax发送数据代码
>
>    ~~~js
>    ~~~
>
> 6. UserController
>
>    ~~~java
>    
>    ~~~
>    ~~
