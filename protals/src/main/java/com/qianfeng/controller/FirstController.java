package com.qianfeng.controller;

import freemarker.template.Template;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/14 0014.
 */
@Controller
public class FirstController {
    @Resource
    private FreeMarkerConfig config;
    @RequestMapping("jump")
    public String jump(Map<String,Object> map, HttpServletRequest request){
        map.put("name","陈浩");
        map.put("x",100);
        String[] s="fsdaf,3wr,re,vf,s,we,tre".split(",");
        map.put("list",s);
        try {
            //获取模板
            Template template = config.getConfiguration().getTemplate("first.ftl");
            File file = new File("D:/mmmm/first.html");
            Writer out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            template.process(map,out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "first";
    }
    @RequestMapping("jump2")
    public String jump2(){
        return "index";
    }
}
