package tech.aistar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 本类用来演示: session作用域
 *
 * @author: Q
 * @date: 2021/11/6 9:33 上午
 */
@RestController
@RequestMapping("/ses")
public class SessionController {
    /**
     * localhost:8081/boot/ses/add?name=success
     * 将数据放入到session作用域
     * @return
     */
    @GetMapping("/add")
    public String add(HttpServletRequest request,String name){
        //获取session对象
        //第一次执行,容器内部会开辟一块session空间
        HttpSession session = request.getSession();
        //存储的数据的格式是key-value
        session.setAttribute("username",name);
        return "add";
    }

    /**
     * 从session作用域中获取数据
     * @return
     */
    @GetMapping("/get")
    public String get(HttpServletRequest request){
        //获取session对象
        HttpSession session = request.getSession();
        //根据key来获取value
        String result = (String) session.getAttribute("username");
        return result;
    }
}
