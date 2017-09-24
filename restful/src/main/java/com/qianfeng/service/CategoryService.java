package com.qianfeng.service;

import com.qianfeng.beans.Category2;
import com.qianfeng.dao.CategoryDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
@Service
public class CategoryService {
    @Resource
    private CategoryDao dao;
    public List<Category2> findAllCategoryForProtal(){
        List<Category2> cates = dao.findAllCategoryForProtal();
        List<Category2> cates2=new ArrayList<Category2>();
        cates2.addAll(cates);
        List<Category2> data=new ArrayList<Category2>();
        for (Category2  cate: cates) {
            if(cate.getPid()==0){
                data.add(cate);
            }
            for (Category2 cate2 : cates2) {
                if (cate2.getLevel()==3&&cate2.getPid()==cate.getId()){
                    cate.getI().add(cate2.getUrl()+"|"+cate2.getText());
                }if(cate2.getPid()==cate.getId()&&cate2.getLevel()==2){
                    cate.getI().add(cate2);
                }
            }
        }
        return data;
    }
}
