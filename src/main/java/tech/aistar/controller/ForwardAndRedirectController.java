package tech.aistar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/10/30/13:53
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