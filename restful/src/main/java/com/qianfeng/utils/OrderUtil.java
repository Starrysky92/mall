package com.qianfeng.utils;

import com.alibaba.fastjson.JSON;
import com.qianfeng.beans.Commodity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class OrderUtil {
    public static List<Commodity> query(String cart){
        String s = Base64Utils.decode(cart);
        List<Commodity> list= new ArrayList<>();
        System.out.println(s);
        list.addAll(JSON.parseArray(s,Commodity.class));
        return list;
    }
}
