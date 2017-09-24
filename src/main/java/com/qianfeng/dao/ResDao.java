package com.qianfeng.dao;

import com.qianfeng.beans.Res;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Repository
public interface ResDao {
    List<Res> findRes(int id);
    List<Res> finAllRes();
    List<Res> findAllResForpem();
    void adduserRes(HashMap<String,Object> map);
    void deleteUserRes(int userid);
    void addres(Res res);
    void updateres(Res res);
    void delres(ArrayList<Integer> ids);
}
