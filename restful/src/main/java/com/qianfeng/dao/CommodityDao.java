package com.qianfeng.dao;

import com.qianfeng.beans.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
@Repository
@Mapper
public interface CommodityDao {
    public Commodity findoneCommodity(String id);
}
