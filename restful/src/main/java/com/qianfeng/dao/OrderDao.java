package com.qianfeng.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
@Repository
@Mapper
public interface OrderDao {
    void creatOrder(Map<String,Object> map);
    void creatOrderdeta(Map<String,Object> map);
}
