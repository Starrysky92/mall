package com.qianfeng.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/20 0020.
 */
public class AliPay implements Serializable{
    @JSONField(name = "out_trade_no")
    private String orderid;
    @JSONField(name = "total_amount")
    private String ordretotal;
    @JSONField(name = "subject")
    private String ordername;
    @JSONField(name = "body")
    private String ordercontent;
    private String product_code="FAST_INSTANT_TRADE_PAY";

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrdretotal() {
        return ordretotal;
    }

    public void setOrdretotal(String ordretotal) {
        this.ordretotal = ordretotal;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrdercontent() {
        return ordercontent;
    }

    public void setOrdercontent(String ordercontent) {
        this.ordercontent = ordercontent;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }
}
