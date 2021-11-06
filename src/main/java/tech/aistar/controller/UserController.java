package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.aistar.model.Result;
import tech.aistar.model.User;
import tech.aistar.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 本类用来演示: 用户控制层
 *
 * @author: success
 * @date: 2021/10/30 2:51 下午
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //控制层调用业务逻辑层
    @Autowired
    private IUserService userService;

    /**
     * ajax请求过来的,才是返回一个json数据出去
     *
     * key1=value&key2=value2
     *
     * 方法的参数的名称和前端url地址上的key的名称保持一致
     *
     * 摆地摊接受参数
     *
     * @return
     */
    @ResponseBody
    @PostMapping
    public Result login(HttpServletRequest request, String username, String password){
        //1. 根据用户名到db中找用户
        User user = userService.login(username);
        //2. 进行判断
        if(user == null)
            return new Result("404","用户不存在!",null);
        //3. user是存在的,但是进一步判断密码
        //password字段是字符串,字符串的比较推荐使用equals方法,不要使用==
        if(user.getPassword().equals(password)){
            //为了区分是否登录
            //将这个登录成功的用户user放入到session作用域中.
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return new Result("200","登录成功!",null);
        }
        //4.意外场景
        return new Result("500","密码错误!",null);
    }
}
