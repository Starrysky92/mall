package com.qianfeng.controller;

import com.qianfeng.beans.Res;
import com.qianfeng.beans.Users;
import com.qianfeng.dao.ResDao;
import com.qianfeng.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
//@Controller+ @ResponseBody
@Controller
public class ResController {
    @Autowired
    private ResDao dao;
    @Resource
    private ResService rs;
    @RequestMapping("findRes")
    @ResponseBody
    public List<Res>  findRes(HttpSession session){
        Users user = (Users) session.getAttribute("user");
        List<Res> res=dao.findRes(user.getId());

        return res;
    }
    @RequestMapping("findAllRes")
    @ResponseBody
    public List<Res> finAllRes(){
        return dao.finAllRes();
    }
    @RequestMapping("findAllResForpem")
    @ResponseBody
    public  List<Res> findAllResForpem(){
        return dao.findAllResForpem();
    }
    @RequestMapping(value = "adduserRes",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String adduserRes(@RequestBody ArrayList<Integer> ids){
        try {
            rs.addtouserRes(ids);
            return "添加成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "添加失败";
        }
    }
    @RequestMapping(value = "addres",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addres(Res res){
        try {
            if (res.getId()==0) {
                dao.addres(res);
            }else {
                dao.updateres(res);
            }
            return "保存成功";
        } catch (Exception e) {
            return "保存失败";
        }
    }
    @RequestMapping(value = "delres",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deluser(@RequestBody ArrayList<Integer> ids){
        if (ids.size()>0){
            try {
                dao.delres(ids);
                return "删除成功";
            } catch (Exception e) {
                return "删除失败";
            }
        }
        return "删除失败";
    }
}
