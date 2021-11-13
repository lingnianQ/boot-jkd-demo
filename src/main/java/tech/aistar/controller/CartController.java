package tech.aistar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.aistar.model.Cart;
import tech.aistar.model.Phone;
import tech.aistar.model.Result;
import tech.aistar.model.User;
import tech.aistar.service.ICartService;
import tech.aistar.service.IPhoneService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Create with Intellij IDEA
 *
 * @Author Q
 * @date 2021/11/13/10:41
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @Autowired
    private IPhoneService phoneService;

    /**
     * restful - http动词
     *
     * get - 查询
     * post - 增加
     * put - 修改
     * delete - 删除
     *
     * @param id 产品id
     * @return
     */
    @ResponseBody
    @PostMapping("/add")
    public Result addCart(Integer id, HttpServletRequest request){
        //获取session
        HttpSession session = request.getSession();
        //取出登录的用户
        User user = (User) session.getAttribute("user");

        //判断一下当前的用户是否添加过这个商品
        Cart c = cartService.find(id,user.getId());
        if(c != null){
            //说明是存在的...
            //更新操作 - update
            int m = cartService.update(c.getId());
            if(m==1)
                return new Result("200","加入购物车成功",null);
            return new Result("500","加入购物车失败",null);
        }

        //创建一个Cart对象
        Cart cart = new Cart();

        //根据产品的id查询出这个产品
        Phone phone = phoneService.getById(id);

        cart.setIntro(phone.getRemark());

        cart.setPhoneId(phone.getId());
        cart.setName(phone.getPhoneName());
        cart.setUrl(phone.getUrls());
        cart.setPrice(phone.getPrice());
        //TODO... 待处理
        cart.setNum(1);
        cart.setTotal(cart.getPrice()*cart.getNum());
        cart.setCreateDate(new Date());
        cart.setStatus(1);
        //物联网技术...
        //无人驾驶技术 - 5G - AI - 百度
        //腾讯-AI医疗
        //阿里-AI农业
        //智慧城市
        //酒店...
        //手机-打电话-上网-直播-     [穿戴设备+智能家居]


        cart.setUserId(user.getId());

        int n = cartService.save(cart);
        if(n==1)
            return new Result("200","加入购物车成功",null);
        return new Result("500","加入购物车失败",null);
    }
}
