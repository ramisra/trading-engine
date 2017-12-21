package com.koinex.tradingengine.implementors;

import java.util.Map;
import java.util.Set;

import com.koinex.tradingengine.configurations.RedisTemplateFactory;
import com.koinex.tradingengine.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

@Configuration
public class SortedSetImpl implements RedisInterface {

    @Autowired
    RedisTemplateFactory redisTemplateFactory;

    private ZSetOperations<String,Object> zSetOperations;
    private static String key;

    public SortedSetImpl(String key){
        this.zSetOperations =  redisTemplateFactory.getRedisTemplate().opsForZSet();
        this.key=key;
    }

    @Override
    public Object save(Object o,Double score){
        return this.zSetOperations.add(this.key,o,score);
    }
    @Override
    public Object update(Object o){
        return this.zSetOperations.add(this.key,o,this.zSetOperations.score(this.key,o));
    }



    @Override
    public Set<Object> findByElement(long start, long end){
        return this.zSetOperations.range(this.key,start,end);
    }
    @Override
    public Set<Object> findAllElements(Double min, Double max){
        return this.zSetOperations.range(this.key,0,this.zSetOperations.size(this.key));
    };
    public void delete(long start,long end){
        this.zSetOperations.removeRange(this.key,start,end);
    }

    @Override
    public Object findByElement(String e) {
        return null;
    }

    @Override
    public Set<Object> findAllElements() {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Object save(Object o) {
        return null;
    }



}