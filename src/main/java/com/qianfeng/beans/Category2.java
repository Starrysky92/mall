package com.qianfeng.beans;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public class Category2 implements Serializable {
    private int id;
    @JSONField(name = "u")
    private String url="2.html";
    @JSONField(name = "n")
    private String text;
    private int pid;
    private Set<Category2> i=new HashSet<Category2>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Set<Category2> getI() {
        return i;
    }

    public void setI(Set<Category2> i) {
        this.i = i;
    }
}
