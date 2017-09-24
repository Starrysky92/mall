package com.qianfeng.beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class Role implements Serializable{
    private int id;
    private String rolename;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
