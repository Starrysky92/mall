package com.qianfeng.beans;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class Res implements Serializable{
    private int id;
    private String text;
    private String url;
    @JSONField(name = "_parentId")
    private int pid;
    private String perms;

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    private Set<Res> children=new HashSet<Res>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Res> getChildren() {
        return children;
    }

    public void setChildren(Set<Res> children) {
        this.children = children;
    }
}
