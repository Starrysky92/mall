package com.qianfeng.beans;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class Imges implements Serializable {
    private String id;
    private String imgname;
    private  String createTime;
    private  String commodityid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }
}
