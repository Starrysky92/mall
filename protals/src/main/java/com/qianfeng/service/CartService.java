package com.qianfeng.service;

import com.alibaba.fastjson.JSON;
import com.qianfeng.bean.Commodity;
import com.qianfeng.utils.Base64Utils;
import com.qianfeng.utils.HttpUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
@Service
public class CartService {
  public String add(String cart, String id, Model m){
      String jsonp = HttpUtils.getJsonp("http://localhost:8082/findoneCommodity/" + id);
      Commodity commodity = JSON.parseObject(jsonp, Commodity.class);
      //购物车集合
      List<Commodity> list=null;
      if (StringUtils.isEmpty(cart)){
            list=new ArrayList<Commodity>();
            commodity.setNum(1);
            list.add(commodity);

      }else {
          list= query(cart);
          if(!list.contains(commodity)){
              commodity.setNum(1);
              list.add(commodity);
          }else {
              int i = list.indexOf(commodity);
              Commodity commodity1 = list.get(i);
              commodity1.setNum(commodity1.getNum()+1);
          }
      }
      String s = JSON.toJSONString(list);
      String encode = Base64Utils.encode(s);
      m.addAttribute("cart",list);
      return encode;
  }
  public List<Commodity> query(String cart){
      String s = Base64Utils.decode(cart);
      List<Commodity> list= new ArrayList<>();
      list.addAll(JSON.parseArray(s,Commodity.class));
      return list;
  }
//    public String updatecart(String id,int num,String cart){
//        Commodity commodity = new Commodity();
//        commodity.setId(id);
//        String s = Base64Utils.decode(cart);
//        List<Commodity> list= new ArrayList<>();
//        list.addAll(JSON.parseArray(s,Commodity.class));
//        int i = list.indexOf(commodity);
//        Commodity commodity1 = list.get(i);
//        commodity1.setNum(num);
//        String json = JSON.toJSONString(list);
//        String encode = Base64Utils.encode(json);
//        return encode;
//    }
    //计算总价款
    public float total(List<Commodity> commoditys){
        float x=0;
        for(Commodity c:commoditys){
            x=x+c.getPrice()*c.getNum();
        }
        return x;
    }
}