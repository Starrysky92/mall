package com.qianfeng.controller;

import com.qianfeng.beans.Commodity;
import com.qianfeng.service.OrderService;
import com.qianfeng.utils.OrderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
@RequestMapping("order")
@Controller
public class OrderController {
    @Resource
    OrderService os;
    @RequestMapping("/creat/{id}/{total}/{cart}")
    public void creatOrder(@PathVariable("id") String id,@PathVariable("total") String total,@PathVariable("cart") String cart){

        //订单数据
        Map<String,Object> map=new HashMap<>();
        map.put("id",id);
        map.put("total",total);
        //订单详情

        Map<String,Object> map2=new HashMap<>();
        List<Commodity> commoditys = OrderUtil.query(cart);
        map2.put("id",id);
        map2.put("list",commoditys);
        os.creatOrder(map,map2);
    }
}
