package com.qianfeng;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class Test implements Serializable{
    private String name;
    private int num;
    public Test(){}
    public Test(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
