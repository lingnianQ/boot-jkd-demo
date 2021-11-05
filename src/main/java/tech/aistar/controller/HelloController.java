package tech.aistar.controller;


import org.springframework.web.bind.annotation.*;

import tech.aistar.model.Result;


/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/10/30/10:33
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public Result hello(){
        return new Result("200","hello-get-体验",null);
    }

    @PostMapping
    public Result hello2(){
        return new Result("200","hello-post-体验",null);
    }

}
