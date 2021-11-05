package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tech.aistar.model.Phone;
import tech.aistar.service.IPhoneService;

import java.util.List;

/**
 * 本类用来演示: 手机业务的控制器
 *
 * @author: success
 * @date: 2021/10/30 2:11 下午
 */


@Controller
public class PhoneController {

    @Autowired
    private IPhoneService phoneService;

    @RequestMapping("product")
    @ResponseBody

    public ModelAndView testFindAll(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("phone/index");
        List<Phone> phoneList= phoneService.findAll();
        mav.addObject("phoneList", phoneList);
        return mav;
    }
}

