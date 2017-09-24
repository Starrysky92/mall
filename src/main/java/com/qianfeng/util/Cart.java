package com.qianfeng.util;

import com.qianfeng.beans.Commodity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
public class Cart {
    Map<String,Commodity> map=new HashMap<String, Commodity>();
    //添加
    public void addcommodity(Commodity commodity){
        if(!map.containsKey(commodity.getId())){
            commodity.setNum(1);
            map.put(commodity.getId(),commodity);
        }else {
            Commodity c = map.get(commodity.getId());
            c.setNum(c.getNum()+1);
        }
    }
    //更新数量
    public void addnum(int num,String id){
        Commodity c = map.get(id);
        c.setNum(num);
    }
    //显示
    public Collection<Commodity> show(){

        return map.values();
    }
    //总价
    public float total(){
        float x=0;
        Collection<Commodity> c = map.values();
        for (Commodity commodity : c) {
            x=x+commodity.getPrice()*commodity.getNum();
        }
        return x;
    }
    //删除
    public void del(String id){
        map.remove(id);
    }
}
