package com.qianfeng.controller;

import com.alibaba.fastjson.JSON;
import com.qianfeng.beans.Category;
import com.qianfeng.beans.Category2;
import com.qianfeng.dao.CategoryDao;
import com.qianfeng.service.CategoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
@RestController
public class CategoryController {
    @Resource
    private CategoryDao dao;
    @Resource
    private CategoryService cs;
    @RequestMapping("finAllCategory")
    public Map finAllCategory(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("rows",dao.findAllCetegory());
        return map;
    }
    @RequestMapping(value = "addcategory.do")
    public String addcate(Category category){
        dao.addcategory(category);
        return "1";
    }
    @RequestMapping("findAllCategory2")
    public List<Category> finAllCategory2(){

        return dao.findAllCategory2();
    }
    @RequestMapping("delcategory")
    public  String delcategory(@RequestBody ArrayList<Integer> ids){

        return "1";
    }
    @RequestMapping("updatecategory")
    public String updatecategory(Category category){
        try {
            dao.updatecategory(category);
            return "修改成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败";
        }
    }
    @RequestMapping(value = "findAllCategoryForProtal",produces = "text/html;charset=utf-8")
    public String findAllCategoryForProtal(){
        List<Category2> allcate = cs.findAllCategoryForProtal();
        String json=JSON.toJSONString(allcate);
        System.out.println(json);
        String rs="category.getDataService({\"data\":"+json+"})";
        return rs;
    }

}
