package com.qianfeng.dao;

import com.qianfeng.beans.Commodity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28 0028.
 */
@Repository
public interface CommodityDao {
    void addcommdity(Commodity commodity);
    List<Commodity> findallcommodity(Map<String,Integer> map);
    List<Commodity> findallcommodity2();
    Commodity findbycommodity(String id);
    int commototal();
    void delcommodity(ArrayList<Integer> ids);
    void updatecommodity(Commodity commodity);
    void findTotal(Map<String,Float> map);
}
