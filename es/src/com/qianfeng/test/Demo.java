package com.qianfeng.test;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class Demo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate date1 = date.minusDays(5);
        MonthDay of = MonthDay.of(9, 22);
        MonthDay from = MonthDay.from(date);
        if (from.equals(of)){
            System.out.println("11111");
        }
        System.out.println(of);


    }
}
