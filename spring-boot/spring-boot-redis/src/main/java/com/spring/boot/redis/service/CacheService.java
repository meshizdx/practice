package com.spring.boot.redis.service;

/**
 * Created by BF100177 on 2017/6/1.
 */
public interface CacheService<K,V> {

    public void set(K key, V val);

    public V get(K key);

}
