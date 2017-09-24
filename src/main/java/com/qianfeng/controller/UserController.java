package com.qianfeng.controller;

import com.alibaba.fastjson.JSON;
import com.qianfeng.beans.Users;
import com.qianfeng.dao.UsersDao;
import com.qianfeng.util.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/22 0022.
 */
@Controller
public class UserController {
    @Resource
    private UsersDao dao;
    @RequestMapping("toLogin")
    public String toLogin(){
        return "redirect:login.html";
    }

    @RequestMapping(value = "login")
    @ResponseBody
    public String login(Users users,@RequestParam(value = "kaptcha")String kaptchaReceived, HttpSession session){
        System.out.println(kaptchaReceived);
        String kaptchaExpected = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {
            return "error";//返回验证码错误  @RequestParam(value = "kaptcha")String kaptchaReceived,
        }
        String s = SecurityUtil.md5Encrpt(users.getPwd());
        users.setPwd(s);
        Users login = dao.login(users);
        session.setAttribute("user",login);
        //主体
        Subject subject = SecurityUtils.getSubject();
        //令牌
        UsernamePasswordToken token = new UsernamePasswordToken(users.getName(),users.getPwd());
        subject.login(token);
        return  "success";
    }
    @RequestMapping("outLogin")
    public String outLogin(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        return toLogin();
    }
    @RequestMapping("login2")
    public String login2(Users users, HttpSession session){
        String s = SecurityUtil.md5Encrpt(users.getPwd());
        users.setPwd(s);
        Users login = dao.login(users);
        session.setAttribute("user",login);
        return  "main";
    }
    @RequestMapping("findAllUser")
    @RequiresPermissions(value = {"user:query"})
    @ResponseBody
    public List<Users> findAllUser(int page,int size){
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("start",(page-1)*size);
        map.put("size",size);
        return dao.findAllUser(map);
    }
    @RequestMapping("adduser")
    @ResponseBody
    public void adduser(Users users){
        if (users.getId()==0){
            String s = SecurityUtil.md5Encrpt(users.getPwd());
            users.setPwd(s);
            dao.adduser(users);
        }else {

            dao.updateUser(users);
        }

    }
    @RequestMapping("deluser")
    @ResponseBody
    public String deluser(@RequestBody ArrayList<Integer> ids){
        if (ids.size()>0){
            dao.deluser(ids);
        }
        return "1";
    }
    @RequestMapping("getusertotal")
    @ResponseBody
    public int gettatole(){
        int gettatole = dao.gettatole();
        return gettatole;
    }
}
