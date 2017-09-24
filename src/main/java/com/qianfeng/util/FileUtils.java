package com.qianfeng.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class FileUtils {
    public static ExecutorService pool;
    static {
        pool= Executors.newFixedThreadPool(5);
    }
}
