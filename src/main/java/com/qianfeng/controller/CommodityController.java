package com.qianfeng.controller;

import com.qianfeng.beans.Commodity;
import com.qianfeng.dao.CommodityDao;
import com.qianfeng.util.IdUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
@Controller
public class CommodityController {
    @Resource
    private CommodityDao dao;
    @RequestMapping("addcommodity")
    @ResponseBody
    public String addcommodity(Commodity commodity){
        try {
            if(commodity.getId().equals("0")) {
                commodity.setId(IdUtils.createId());
                dao.addcommdity(commodity);
            }else {
                dao.updatecommodity(commodity);
            }
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }
    @RequestMapping("findallcommodity")
    @ResponseBody
    public List<Commodity> findallcommodity(int page,int size){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("start",(page-1)*size);
        map.put("size",size);
        return dao.findallcommodity(map);
    }
    @RequestMapping("protal.do")
    public String findprotatl(HttpSession session){
        List<Commodity> commos = dao.findallcommodity2();
        session.setAttribute("commos",commos);
        return "protatl";
    }
    @RequestMapping("getcommototal")
    @ResponseBody
    public int getcommototal(){
        return dao.commototal();
    }

    @RequestMapping("delcommodity")
    @ResponseBody
    public String delcommodity(@RequestBody ArrayList<Integer> ids){
        try {
            dao.delcommodity(ids);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "删除失败";
    }

    @RequestMapping("findTotal.do")
    @ResponseBody
    public  String findTotal(){
        Map<String,Float> map=new HashMap<String, Float>();
        map.put("x",5000f);
        dao.findTotal(map);
        return ""+map.get("y");
    }
}
