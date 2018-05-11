package cn.jyuyang.cache;

import cn.jyuyang.entity.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class RedisCacheUtil {
    private RedisTemplate redisTemplate;
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new StringRedisSerializer());
    }

    public Object getValue(String key,Class clazz){
        if(redisTemplate.hasKey(key)) {
            String json = (String) redisTemplate.opsForValue().get(key);

            return new Gson().fromJson(json,clazz);
        } else{
          return null;
        }
    }

    public void setValue(String key,Object o){
        String json = new Gson().toJson(o);

        redisTemplate.opsForValue().set(key,json);
    }


    public void setValue(String key,Object o,long expires){
        String json = new Gson().toJson(o);

        redisTemplate.opsForValue().set(key,json,expires, TimeUnit.SECONDS);
    }

    public void delValue(String key){
        redisTemplate.delete(key);
    }
}
