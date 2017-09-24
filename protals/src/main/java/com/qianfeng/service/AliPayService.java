package com.qianfeng.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.qianfeng.alipay.AliPayConfig;
import com.qianfeng.bean.AliPay;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/20 0020.
 */
@Service
public class AliPayService {
    public String pay2(AliPay ap){
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl, AliPayConfig.app_id, AliPayConfig.merchant_private_key, "json", AliPayConfig.charset, AliPayConfig.alipay_public_key, AliPayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AliPayConfig.return_url);
        alipayRequest.setNotifyUrl(AliPayConfig.notify_url);
        String json = JSON.toJSONString(ap);
        alipayRequest.setBizContent(json);
        try {
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            return  result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return "";
    }
}
