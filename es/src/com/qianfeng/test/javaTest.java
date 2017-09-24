package com.qianfeng.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class javaTest {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        },1000,3000);
    }
}
