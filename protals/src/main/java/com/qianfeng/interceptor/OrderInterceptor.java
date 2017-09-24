package com.qianfeng.interceptor;

import com.qianfeng.utils.HttpUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/9/20 0020.
 */
public class OrderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag=false;
        Cookie[] cookies = httpServletRequest.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("token")){
                String token = c.getValue();
                String s = HttpUtils.getJsonp("http://localhost:8091/islogin?token=" + token);
                flag = Boolean.parseBoolean(s);
                break;
            }
        }
        if (flag){
            return flag;
        }else {
            httpServletResponse.sendRedirect("http://localhost:8091/ssologin.html");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
