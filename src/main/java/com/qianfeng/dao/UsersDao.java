package com.qianfeng.dao;

import com.qianfeng.beans.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/22 0022.
 */
@Repository
public interface UsersDao {
    public Users login(Users users);
    List<Users> findAllUser(Map<String,Integer> map);
    void adduser(Users users);
    void deluser(ArrayList<Integer> ids);
    void updateUser(Users users);
    int gettatole();
}
