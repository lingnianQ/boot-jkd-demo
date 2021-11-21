package tech.aistar.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.aistar.model.*;
import tech.aistar.service.ICollectService;
import tech.aistar.service.IPhoneService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/11/20/9:38
 */
@Controller
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private ICollectService collectService;

    @Autowired
    private IPhoneService phoneService;
    @GetMapping("/index")
    public String index(HttpServletRequest request, @RequestParam(value = "currentPage",required=false,defaultValue="1")Integer currentPage){
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        List<Collect> collectList = collectService.loadAll(currentPage, user.getId());
        PageInfo<Collect> page=new PageInfo<Collect>(collectList);
        request.setAttribute("pageInfo",page);
        //分页
        request.setAttribute("totalPage",page.getPages());
        return "collect/index";
    }

    @PostMapping("/del")
    @ResponseBody
    public Result del(Integer id){
        int n = collectService.deleteById(id);
        if(n==1)
            return new Result("200","删除成功",null);
        return new Result("500","删除失败",null);
    }

    @PostMapping("allDel")
    @ResponseBody
    public void allDel(HttpServletRequest request, HttpServletResponse response){
        String items = request.getParameter("delitems");
        List<String> delList = new ArrayList<String>();
        String[] strs = items.split(",");
        for (String str : strs) {
            delList.add(str);
        }
        collectService.batchDeletes(delList);
    }
    @ResponseBody
    @PostMapping("/add")
    public Result addCart(Integer id, HttpServletRequest request){
        //获取session
        HttpSession session = request.getSession();
        //取出登录的用户
        User user = (User) session.getAttribute("user");
        //判断一下当前的用户是否添加过这个商品
        Collect c = collectService.find(id,user.getId());


        if(c != null){
            //说明是存在的...
            //更新操作 - update
            int m = collectService.deleteById(c.getId());
            phoneService.supCount(id);
            if(m==1)
                return new Result("201","取消收藏",null);
            return new Result("501","取消收藏失败",null);
        }
        //创建一个Collect对象
        Collect collect = new Collect();
        //根据产品的id查询出这个产品
        Phone phone = phoneService.getById(id);
        collect.setIntro(phone.getRemark());
        collect.setPhoneId(phone.getId());
        collect.setName(phone.getPhoneName());
        collect.setUrl(phone.getUrls());
        collect.setPrice(phone.getPrice());
        //TODO... 待处理
        collect.setNum(1);
        collect.setTotal(collect.getPrice()*collect.getNum());
        collect.setCreateDate(new Date());
        collect.setStatus(1);
        collect.setUserId(user.getId());
        int n = collectService.save(collect);
        phoneService.addCount(id);
        if(n==1)
            return new Result("200","收藏成功",null);
        return new Result("500","收藏失败",null);
    }
}
