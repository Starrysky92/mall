package com.qianfeng.controller;

import com.qianfeng.beans.Commodity;
import com.qianfeng.dao.CommodityDao;
import com.qianfeng.util.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
@Controller
public class CartController {
    @Resource
    private CommodityDao dao;
    @RequestMapping("addcart.do")
    public String addCart(String id, HttpSession session){
        Commodity commodity = dao.findbycommodity(id);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null) {
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
            cart.addcommodity(commodity);

        return "redirect:cart.jsp";
    }
    @RequestMapping("addnum.do")
    @ResponseBody
    public String addnum(int num,String id,HttpSession session){
        System.out.println(num+"  "+id);
        Cart cart = (Cart) session.getAttribute("cart");
        cart.addnum(num,id);
        return "1";
    }
    @RequestMapping("lessnum.do")
    @ResponseBody
    public String lessnum(int num,String id,HttpSession session){
        System.out.println(num+"  "+id);
        Cart cart = (Cart) session.getAttribute("cart");
        cart.addnum(num,id);
        return "1";
    }
    @RequestMapping("deletecart.do")
    @ResponseBody
    public String deletecart(String id,HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.del(id);
        return "1";
    }
}
