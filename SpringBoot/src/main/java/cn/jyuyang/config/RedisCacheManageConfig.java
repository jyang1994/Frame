package cn.jyuyang.config;

import cn.jyuyang.prop.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCacheManageConfig {

    @Autowired
    private RedisProperties properties;

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){

        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setUsePrefix(true);
        redisCacheManager.setExpires(properties.getExpires());
        return redisCacheManager;

    }
}
