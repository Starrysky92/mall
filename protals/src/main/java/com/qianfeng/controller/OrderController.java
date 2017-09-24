package com.qianfeng.controller;

import com.qianfeng.bean.AliPay;
import com.qianfeng.bean.Commodity;
import com.qianfeng.service.AliPayService;
import com.qianfeng.service.CartService;
import com.qianfeng.utils.Constants;
import com.qianfeng.utils.HttpUtils;
import com.qianfeng.utils.IdUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
@RequestMapping("order")
@Controller
public class OrderController {
    @Resource
    private CartService cs;
    @Resource
    private AliPayService ps;
    @RequestMapping("/computer")
    public String computer(@CookieValue(value = "cart") String cart, Model m){
        List<Commodity> commoditys = cs.query(cart);
        m.addAttribute("cart",commoditys);
        return "order";
    }
    @RequestMapping("/create")
    @ResponseBody
    public String createOrder(@CookieValue(value = "cart") String cart){
        String id= IdUtils.createId();
        List<Commodity> commoditys = cs.query(cart);
        float total = cs.total(commoditys);
        StringBuilder builder=new StringBuilder();
        builder.append(Constants.resURl);
        builder.append("/order/creat");
        builder.append("/"+id);
        builder.append("/"+total);
        builder.append("/"+cart);
        HttpUtils.getJson2(builder.toString());
        AliPay ap=new AliPay();
        ap.setOrderid(id);
        ap.setOrdercontent("3213");
        ap.setOrdername("xiezi");
        ap.setOrdretotal(""+total);
        return ps.pay2(ap);
    }
}
