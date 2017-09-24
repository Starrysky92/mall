package com.qianfeng.controller;

import com.alibaba.fastjson.JSON;
import com.qianfeng.beans.Category2;
import com.qianfeng.service.CategoryService;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@Controller
public class CategoryController {
    @Resource
    private CategoryService cs;
    @RequestMapping(value = "findAllCategoryForProtal",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String findAllCategoryForProtal(){
        List<Category2> allcate = cs.findAllCategoryForProtal();
        String json= JSON.toJSONString(allcate);
        String rs="category.getDataService({\"data\":"+json+"})";
        return rs;
    }
}
