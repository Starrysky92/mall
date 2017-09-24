package com.qianfeng.service;

import com.qianfeng.dao.ResDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
@Service
public class ResService {
    @Resource
    private ResDao dao;
    @Transactional
    public void addtouserRes(ArrayList<Integer> ids){
        HashMap<String,Object> map=new HashMap<String, Object>();
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < ids.size(); i++) {
            if(i==0){
                map.put("userid",ids.get(i));
                dao.deleteUserRes(ids.get(i));
            }else {
                list.add(ids.get(i));
            }
        }
        map.put("list",list);
        dao.adduserRes(map);
    }
}
