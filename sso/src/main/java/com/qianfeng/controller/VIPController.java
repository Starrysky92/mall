package com.qianfeng.controller;

import com.qianfeng.bean.Member;
import com.qianfeng.dao.MemberDao;
import com.qianfeng.util.IdUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/9/20 0020.
 */
@Controller
public class VIPController {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private MemberDao md;
    @RequestMapping("ssologin.do")
    public String ssoLogin(Member member, HttpServletResponse response){
        String token = IdUtils.createId();
        Member m = md.findMember(member);
       if(m==null){
           return "redirect:ssologin.html";
       }else {
           Cookie cookie=new Cookie("token",token);
           cookie.setMaxAge(30*60);
           cookie.setPath("/");
           response.addCookie(cookie);
           redisTemplate.setKeySerializer(new StringRedisSerializer());
           redisTemplate.opsForValue().set(token,m);
           return "redirect:http://localhost:8090/order/computer";
       }
    }
    @RequestMapping("islogin")
    @ResponseBody
    public boolean islogin(String token){
        Object o = redisTemplate.opsForValue().get(token);
        return o==null?false:true;
    }
}
