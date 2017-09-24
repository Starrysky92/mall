package com.qianfeng.config;

import com.qianfeng.interceptor.OrderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/9/20 0020.
 */
@Configuration
public class OrderConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new OrderInterceptor()).addPathPatterns("/order/computer");
        super.addInterceptors(registry);
    }
}
