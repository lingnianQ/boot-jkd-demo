package tech.aistar.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String index(HttpServletRequest request,String name ,Model model,
                        @RequestParam(value = "currentPage",required=false,defaultValue="1")Integer currentPage){

//        List<Phone> phoneList = phoneService.loadAll(name,currentPage);
//        //放入到request作用域中
//        request.setAttribute("phoneList",phoneList);

        if(name!=null && name.trim().length()>0){
            request.setAttribute("name",name);
        }

        List<Phone> list = phoneService.loadAll(name,currentPage);
        PageInfo<Phone> page = new PageInfo<Phone>(list);
        model.addAttribute("pageInfo", page);

        //测试数据
        System.out.println(list);
        for(int i = 0;i < list.size();i++) {
            System.out.println(list.get(i));
        }
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
