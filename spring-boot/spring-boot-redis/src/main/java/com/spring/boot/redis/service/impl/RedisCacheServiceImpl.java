package com.spring.boot.redis.service.impl;

import com.spring.boot.redis.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by BF100177 on 2017/6/1.
 */
@Service
public class RedisCacheServiceImpl<K,V> implements CacheService<K,V> {

    @Autowired
    RedisTemplate<K, V> redisTemplate;


    @Override
    public void set(K key, V val) {
        redisTemplate.opsForValue().set(key, val);
    }

    @Override
    public V get(K key) {
       return redisTemplate.opsForValue().get(key);
    }
}
