package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tech.aistar.model.Phone;
import tech.aistar.service.IPhoneService;

import java.util.List;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/11/04/20:07
 */
@Controller

public class TestController {

    @Autowired
    private IPhoneService phoneService;

    @RequestMapping("p1")
    @ResponseBody

    public ModelAndView testFindAll(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("phone/h1");
        List<Phone> phoneList= phoneService.findAll();
        mav.addObject("phoneList", phoneList);
        return mav;
    }
}