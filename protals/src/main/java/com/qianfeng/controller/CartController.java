package com.qianfeng.controller;

import com.alibaba.fastjson.JSON;
import com.qianfeng.bean.Commodity;
import com.qianfeng.service.CartService;
import com.qianfeng.utils.Base64Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
@Controller
@RequestMapping("cart")
public class CartController {
    @Resource
    CartService cs;
    @RequestMapping("add/{id}")
    public String add(@CookieValue(value = "cart",required = false) String cart, @PathVariable String id, HttpServletResponse response, Model m){
        String s= cs.add(cart, id, m);
        Cookie cookie = new Cookie("cart", s);
        cookie.setMaxAge(60*60*24*30);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "cart";
    }

    @RequestMapping("lookcart")
    public String query(@CookieValue(value = "cart",required = false) String cart,Model m){
        m.addAttribute("cart",cs.query(cart));
        return "cart";
    }
    @RequestMapping("/update/{id}/{num}")
    @ResponseBody
    public String updatecart(@PathVariable(value = "id",required = false) String id,@PathVariable(value = "num",required = false) int num,@CookieValue(value = "cart",required = false) String cart,HttpServletResponse response){
        List<Commodity> commodityList = cs.query(cart);
        Commodity c=new Commodity();
        c.setId(id);
        //获取索引
        int index = commodityList.indexOf(c);
        //根据索引获取对象
        Commodity commodity = commodityList.get(index);
        commodity.setNum(num);
        String json = JSON.toJSONString(commodityList);
        String encode = Base64Utils.encode(json);
        Cookie cookie = new Cookie("cart", encode);
        cookie.setMaxAge(60*60*24*30);
        cookie.setPath("/");
        response.addCookie(cookie);
        float total = cs.total(commodityList);
        return ""+total;
    }

}
