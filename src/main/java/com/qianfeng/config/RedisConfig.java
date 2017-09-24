package com.qianfeng.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * Created by Administrator on 2017/9/12 0012.
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
    @Bean
    public JedisConnectionFactory createFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("127.0.0.1");
        factory.setPort(6379);
        return  factory;
    }
    @Bean
    public RedisTemplate<String,String> createTem(JedisConnectionFactory factory){
        RedisTemplate<String, String> template = new RedisTemplate<String, String>();
        template.setConnectionFactory(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
    @Bean
    public CacheManager createCache(RedisTemplate<String,String> template){
        RedisCacheManager manager = new RedisCacheManager(template);
        return manager;
    }

}
