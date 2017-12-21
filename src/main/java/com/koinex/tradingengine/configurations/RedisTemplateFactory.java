package com.koinex.tradingengine.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisTemplateFactory{
    
    @Autowired
    RedisConnection redisConnection;

    public RedisTemplate<String,Object> getRedisTemplate(){
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnection.getRedisConnection());
        return template;
    }
    
}