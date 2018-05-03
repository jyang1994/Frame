package cn.jyuyang.jedis;

import cn.jyuyang.entity.User;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class springRedisTest {
    @Autowired
    private JedisPool jedisPool;
    @Test
    public void saveString(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("kemu","wuli");
        System.out.println(jedis.get("kemu"));
    }

    @Test
    public void saveEntity(){
        User user = new User(1,"焦作");
        String json = new Gson().toJson(user);

        Jedis jedis = jedisPool.getResource();
        jedis.set("1",json);

        System.out.println(new Gson().fromJson(jedis.get("1"),User.class));
    }
}
