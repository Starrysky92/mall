package com.qianfeng.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class SecurityUtil {
    public static String md5Encrpt(String value){
        StringBuilder sd=new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(value.getBytes());
            byte[] target=md5.digest();
            for (int i = 0; i <target.length ; i++) {
                int x=target[i]&0xff;
                x=x+1;
                if (x<16){
                    sd.append(0);
                }
                sd.append(Integer.toHexString(x));

            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sd.toString();
    }
}
