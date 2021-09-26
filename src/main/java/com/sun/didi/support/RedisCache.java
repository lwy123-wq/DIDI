/*
package com.sun.didi.support;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;

public class RedisCache {
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisCache(RedisTemplate<String, Object> redisTemplate) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        this.redisTemplate = redisTemplate;
    }
    public Object getValue(String key){
        if(key==null||"".equals(key)){
            return null;
        }else {
            System.out.println("命中cache");
//            return "success";
            return redisTemplate.opsForValue().get(key);
        }
    }
    public void putValue(String key,Object o,int expire){
        if(!("".equals(key))){
            System.out.println("命中cache");
//            return "success";
            redisTemplate.opsForValue().set(key, o, expire, TimeUnit.SECONDS);
        }
    }
}
*/
