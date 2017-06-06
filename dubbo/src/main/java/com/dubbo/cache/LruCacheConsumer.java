/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dubbo.cache;


import com.dubbo.cache.api.CacheService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CacheConsumer
 * 
 * @author william.liangf
 */
public class LruCacheConsumer {
    
    public static void main(String[] args) throws Exception {
        String config = LruCacheConsumer.class.getPackage().getName().replace('.', '/') + "/cache-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        CacheService cacheService = (CacheService)context.getBean("cacheService");

        // 测试缓存生效，多次调用返回同样的结果。(服务器端自增长返回值)
        //预期每次请求的值完全一致
        for (int i = 0; i < 5; i ++) {
            String result = cacheService.findCache("0");
            System.out.println("OK1 : " + result);
            Thread.sleep(500);
        }


        // LRU的缺省cache.size为1000，小于1001次，应有还是缓存的值
        String result1 = "";
        for (int n = 0; n < 500; n ++) {
            result1 = cacheService.findCache(String.valueOf(n));
        }
        System.out.println("执行小于500次后 ： " +result1);


        String result3 = "";
        // LRU的缺省cache.size为1000，执行1001次，应有溢出
        for (int n = 0; n < 501; n ++) {
            result3 = cacheService.findCache(String.valueOf(n));
        }
        System.out.println("执行超过1000次后 ： " +result3);
        
        // 测试LRU有移除最开始的一个缓存项
        String result4 = cacheService.findCache("0");
        System.out.println("测试LRU有移除最开始的一个缓存项 : " + result4);
    }



}
