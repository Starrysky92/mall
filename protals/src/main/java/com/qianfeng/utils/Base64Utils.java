package com.qianfeng.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class Base64Utils {
    //编码
    public static String encode(String src){
        return Base64.getEncoder().encodeToString(src.getBytes());
    }
    //解码
    public static String decode(String src){
        byte[] bytes = Base64.getDecoder().decode(src);
        try {
            String s=new String(bytes,"utf-8");
            return s;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
