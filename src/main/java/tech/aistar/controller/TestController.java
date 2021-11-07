package tech.aistar.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("p1")
public class TestController {
//
//    @Autowired
//    private IPhoneService phoneService;
//
//    @GetMapping("/h1")
//    public ModelAndView testFindAll(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("phone/h1");
//        List<Phone> phoneList= phoneService.loadAll();
//        mav.addObject("phoneList", phoneList);
//        return mav;
//    }
//
//    @GetMapping("h2")
//    public String orderList(Model model, @RequestParam(value = "currentPage",required=false,defaultValue="1")Integer currentPage) {
//        List<Phone> list = phoneService.loadAll(currentPage);
//        PageInfo<Phone> page = new PageInfo<Phone>(list);
//        model.addAttribute("pageInfo", page);
//        //测试数据
//        System.out.println(list);
//        for(int i = 0;i < list.size();i++) {
//            System.out.println(list.get(i));
//        }
//        return "phone/h1";
//    }
}