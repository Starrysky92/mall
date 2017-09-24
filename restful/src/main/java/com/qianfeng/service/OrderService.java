package com.qianfeng.service;

import com.qianfeng.dao.OrderDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
@Service
public class OrderService {
    @Resource
    private OrderDao od;
    @Transactional
    public void creatOrder(Map<String,Object> map,Map<String,Object> map2){
        od.creatOrder(map);
        od.creatOrderdeta(map2);
    }

}
