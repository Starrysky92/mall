package com.qianfeng.controller;

import com.qianfeng.beans.Role;
import com.qianfeng.dao.RoleDao;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Controller
public class RoleController {
    @Resource
    private RoleDao dao;
    @RequestMapping("finAllRole")
    @RequiresPermissions(value = {"user:role"})
    @ResponseBody
    public List<Role> findAllRole(int page,int size){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("start",(page-1)*size);
        map.put("size",size);
        return dao.findallrole(map);
    }
    @RequestMapping("addRole")
    @ResponseBody
    public String addRole(Role role){
        try {
            if (role.getId()==0){
                dao.addRole(role);
            }else {
                dao.updateRole(role);
            };
            return "1";
        } catch (Exception e) {
            return "-1";
        }
    }
    @RequestMapping("delrole")
    @ResponseBody
    public String deltole(@RequestBody ArrayList<Integer> list){
        dao.delrole(list);
        return "1";
    }
    @RequestMapping("getroletotal")
    @ResponseBody
    public int gettatole(){
        int gettatole = dao.getroletatole();
        return gettatole;
    }
}
