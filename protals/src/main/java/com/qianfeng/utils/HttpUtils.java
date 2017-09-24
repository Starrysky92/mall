package com.qianfeng.utils;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class HttpUtils {
    public static String getJsonp(String path){
        try {
            URL url=new URL(path);
            URLConnection con = url.openConnection();
            con.connect();
            InputStream in = con.getInputStream();
            byte[] bytes=new byte[1024];
            int count=0;
            StringBuilder builder=new StringBuilder();
            while ((count=in.read(bytes))!=-1){
                String s=new String(bytes,0,count,"utf-8");
                builder.append(s);
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    public static void getJson2(String path){
        try {
            URL url = new URL(path);
            URLConnection con = url.openConnection();
            con.connect();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
