package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.aistar.model.Phone;
import tech.aistar.service.IPhoneService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 本类用来演示: 手机业务的控制器
 *
 * @author: Q
 * @date: 2021/10/30 2:11 下午
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private IPhoneService phoneService;
    @GetMapping("/index")
    public String index(HttpServletRequest request){
        List<Phone> phoneList= phoneService.loadAll();

        request.setAttribute("phoneList",phoneList);
        //转发到页面 - jsp对应的逻辑视图名称 - 配合yml前缀和后缀
        return "phone/index";
    }

    @GetMapping("/exit")
    public String exit(HttpServletRequest request){
        //1. 获取session
        HttpSession session = request.getSession();
        //2. 清空session
        session.invalidate();
        return "redirect:/phone/index";
    }
}
//package tech.aistar.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import tech.aistar.model.Phone;
//import tech.aistar.service.IPhoneService;
//
//import java.util.List;
//
///**
// * 本类用来演示: 手机业务的控制器
// *
// * @author: success
// * @date: 2021/10/30 2:11 下午
// */
//
//
//@Controller
//public class PhoneController {
//
//    @Autowired
//    private IPhoneService phoneService;
//
//    @RequestMapping("product")
//    @ResponseBody
//
//    public ModelAndView testFindAll(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("phone/index");
//        List<Phone> phoneList= phoneService.findAll();
//        mav.addObject("phoneList", phoneList);
//        return mav;
//    }
//}
//
