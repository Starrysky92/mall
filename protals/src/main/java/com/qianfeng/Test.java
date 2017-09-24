package com.qianfeng;

import com.qianfeng.utils.Base64Utils;
import com.qianfeng.utils.HttpUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class Test {
    public static void main(String[] args) {
        String decode = Base64Utils.decode("W3siY2F0ZWdvcnlpZCI6MywiY29udGVudCI6IjxwPuajkueQg+mihuWkueWFiyDkvJHpl7LnroDnuqYg5pe25bCa5Y+j6KKLIOWIqeiQveW5sue7gzwvcD5cclxuIiwiaWQiOiI4MWNmZWIwMDE0ZDc0NDU5OGI1MzE5NTIwMzY0ZDM0MjE1MDQwOTcwMzMyMDAiLCJuYW1lIjoi6buR5bqV5qC85a2Q5LyR6Zey5aS55YWL55S3IiwibnVtIjoxLCJwcmljZSI6My4wfV0=");
        System.out.println(decode);
    }
}
