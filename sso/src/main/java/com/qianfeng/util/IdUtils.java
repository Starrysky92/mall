package com.qianfeng.util;

import java.util.UUID;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class IdUtils {
    public static String createId(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String y = s.replaceAll("-", "");
        long l = System.currentTimeMillis();
        return y+l;
    }
}
