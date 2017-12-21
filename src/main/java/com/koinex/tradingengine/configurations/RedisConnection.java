package com.koinex.tradingengine.configurations;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;


class RedisConnection {

    public JedisConnectionFactory getRedisConnection(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        /* Variables for connections need to be picked from the system */
        jedisConnectionFactory.setHostName("localhost");
        jedisConnectionFactory.setPort(6379);
        return jedisConnectionFactory;
    }

}