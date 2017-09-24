package com.qianfeng.dao;

import com.qianfeng.beans.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Repository
public interface RoleDao {
    List<Role> findallrole(Map<String,Integer> map);
    void addRole(Role role);
    void updateRole(Role role);
    void delrole(ArrayList<Integer> list);
    int getroletatole();
}
