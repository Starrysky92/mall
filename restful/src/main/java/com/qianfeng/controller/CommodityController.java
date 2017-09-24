package com.qianfeng.controller;

import com.qianfeng.beans.Commodity;
import com.qianfeng.dao.CommodityDao;
import freemarker.template.Template;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.annotation.Resource;
import java.io.*;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Controller
public class CommodityController {
    @Resource
    private FreeMarkerConfig config;
    @Resource
    private CommodityDao dao;
    @RequestMapping(value = "creatcomm",produces = "text/html;charset=utf-8")
    public String createComm(String collback,String sku){
        Commodity commodity = dao.findoneCommodity(sku);
        try {
            Template template = config.getConfiguration().getTemplate("item.ftl");
            File file = new File("D:/mmmm/" + sku + ".html");
            Writer out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            template.process(commodity,out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collback+"('上传成功');";
    }
    @RequestMapping("findoneCommodity/{id}")
    @ResponseBody
    public Commodity findoneCommodity(@PathVariable String id){

        return dao.findoneCommodity(id);
    }
}
