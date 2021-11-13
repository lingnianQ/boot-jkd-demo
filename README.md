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

# 第三次实验

> 1. 代码迁移到springboot工程中
>
> 2. PhoneController
     >
     >    2-1. 调用service的查询所有产品的方法
     >
     >    2-2. 数据放入到request作用域中
     >
     >    2-3. 转发到产品的首页
>
> 3. **JSP -> EL表达式 -> JSTL->c标签的使用方式**

> 提交地址:
>
> http://xzc.cn/gZ6J6tkLor

# 处理一下导航

> 判别登录是成功还是不成功的?
>
> 需要登录成功之后,将user对象放入到session作用域

> **sesssion作用域 - "容器内存中的区域",生命周期就是"一次会话期间" , 从浏览器打开 - 浏览器关闭**

# TCP协议

> 传输层
>
> 成功建立连接 - 三次握手,四次挥手
>
> 目的 - 就是为了在不可靠的网络中建立可靠稳定的连接.

> websoket-一次tcp连接

# HTTP协议

> 应用层

> 网络中传输的数据必须要遵守的格式.

> **超文本传输协议 - 特点:无状态的协议**
>
> **服务器[tomcat]是不能够判别出俩次请求是来自于同一个client[客户端].**

# Session的跟踪机制 - 考试

> 1. 会话的跟踪机制
> 2. cookie怎么管理session

## 过程

> 1. 当第一次请求http://10.132.218.243:8081/boot/ses/add?name=admin
     >
     >    当**请求第一次**到达下方代码的时候
     >
     >    ~~~java
>    HttpSession session = req.getSession();
>    ~~~
     >
     >    服务器就会为这个客户端在内部开辟一块session空间,并且给这个session空间分配了一个**唯一的一个id**.这个id在不同的浏览器上的名称是不一样的,chrome - **JSESSIONID=1BC4450C4370579C37E42F0EA2CE2BC6**
>
> 2. 通过网络进行查看的时候,发现**响应头信息中包含了**
     >
     >    ~~~java
>    Set-Cookie: JSESSIONID=EA7C196180B582CD278288513D81FB63; Path=/boot; HttpOnly
>    ~~~
     >
     >    说明了,服务器在server端创建了一个cookie对象.该cookie对象保存了刚刚的jsessionid,并且将这个cookie通过响应头信息
     >
     >    将这个cookie一起发送到client客户端,并且保存在客户端 - [cookie在server创建,在client存储]
>
> 3. 再次发送请求http://10.132.218.243:8081/boot/ses/get
     >
     >    通过网络 - 请求头信息 -  Cookie: JSESSIONID=EA7C196180B582CD278288513D81FB63
     >
     >    客户端将带有sessionid的cookie一起发送给server
>
> 4. server解析这个cookie,解析出seesionid之后,就可以根据这个id找出这个客户端之前的那个session空间.

# JSTL

> 1. 引入标签库 - core
     >
     >    在nav.jsp
     >
     >    ~~~js
>    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
>    ~~~

# SQL

~~~mysql
DROP TABLE IF EXISTS `phonetype`;
CREATE TABLE `phonetype` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phonetype
-- ----------------------------
INSERT INTO `phonetype` VALUES ('1', '小米');
INSERT INTO `phonetype` VALUES ('2', '华为');
INSERT INTO `phonetype` VALUES ('3', '苹果');

DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` double(6,0) NOT NULL,
  `intro` varchar(100) NOT NULL,
  `phonetype_id` int(5) NOT NULL,
  `url` varchar(300) DEFAULT NULL,
  `status` int(1),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of phone
-- ----------------------------
INSERT INTO `phone` VALUES ('1', '华为畅享9plus', '1199', '【最高直降200】Huawei/华为 畅享9 Plus 全面屏超清大屏四摄学生智能手机畅享9p', '2', '001.webp',1);

INSERT INTO `phone` VALUES ('2', 'iPhone XS Max', '8888', '【下单立减300元】Apple/苹果 iPhone Xs Max 256G 全网通4G手机 双卡双待苹果iphonexsmax', '3', '002.webp',0);

INSERT INTO `phone` VALUES ('3', ' 小米9', '3700', 'Xiaomi/小米 小米9透明九se故宫版10尊享探索plus全新手机骁龙855', '1', '003.webp',1);

INSERT INTO `phone` VALUES ('4', '华为p30', '4488', '【6期免息】Huawei/华为 P30全面屏超感光徕卡三摄变焦双景录像980芯片智能手机p30', '2', '004.webp',1);

INSERT INTO `phone` VALUES ('5', 'iPhone 8', '3400', '【下单立减190元】Apple/苹果 iPhone 8 64G 移动联通电信全网通4G手机 官方正品苹果iPhone8', '3', '005.webp',1);

INSERT INTO `phone` VALUES ('6', 'RedMi手表', '299', '【下单立减190元】Apple/苹果 iPhone 8 64G 移动联通电信全网通4G手机 官方正品苹果iPhone8', '3', '006.webp',1);

INSERT INTO `phone` VALUES ('7', 'RedMi青春版', '299', '【下单立减190元】Apple/苹果 iPhone 8 64G 移动联通电信全网通4G手机 官方正品苹果iPhone8', '3', '007.webp',1);

INSERT INTO `phone` VALUES ('8', 'RedMi豪华版', '699', '【下单立减190元】Apple/苹果 iPhone 8 64G 移动联通电信全网通4G手机 官方正品苹果iPhone8', '3', '008.webp',1);

INSERT INTO `phone` VALUES ('9', 'RedMi乞丐版', '599', '【下单立减190元】Apple/苹果 iPhone 8 64G 移动联通电信全网通4G手机 官方正品苹果iPhone8', '3', '009.webp',1);

~~~

# 任务清单

> 1. 处理导航,登录和未登录显示内容不一样   √
>
> 2. 首页手机数据展示  √
>
> 3. 首页搜索任务  √
     >
     >    ~~~java
>    Elasticsearch 分布式的搜索引擎技术
>    solr
>    ~~~
>
> 4. 加入购物车
     >
     >    | id   | phone_id | name          | url      | price | intro | num  | total | user_id | create_date | status |      |      |      |      |      |      |      |      |      |
     >    | ---- | -------- | ------------- | -------- | ----- | ----- | ---- | ----- | ------- | ----------- | ------ | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
     >    | 1    | 1        | 华为畅享9plus | 001.webp | 1199  | ....  | 2    | 1199  | 1       |             | 0      |      |      |      |      |      |      |      |      |      |
     >    |      |          |               |          |       |       |      |       |         |             |        |      |      |      |      |      |      |      |      |      |
     >    |      |          |               |          |       |       |      |       |         |             |        |      |      |      |      |      |      |      |      |      |
     >
     >    ~~~mysql
>    drop table cart;
>    create table cart(
>    	id int(7) primary key auto_increment,
>      phone_id int(7),
>      name varchar(20),
>      url varchar(20),
>      price double(101,2),
>      intro varchar(20),
>      num int(7),
>      total double(10,2),
>      user_id int(7),
>      create_date datetime,
>      status int(1)
>    );
>    ~~~
>

# 实验四任务 - 添加购物车

> 购物车(1)  - 添加购物车
>
> http://xzc.cn/QzyPYikv1a

# 实验五任务 - 购物车展示

> 购物车(2) - 查看购物车
>
> 要求:
>
> 1. 使用table[响应式表格]来展示购物车中的数据
> 2. 能够实现使用标签页来**分页展示**购物车中数据
> 3. http://xzc.cn/qH805H8CEd

# 实验六任务 - 购物车操作

> 1. 在购物车页面,能够使用**ajax技术**来修改购物车的商品购买数量
> 2. 能够实现删除单个和批量删除购物车信息
> 3. **附加题 - 异步删除**
> 4. http://xzc.cn/c4cf5OMsW4
