package cn.jyuyang.jedis;

import cn.jyuyang.entity.User;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class ProtostuffTest {

    @Autowired
    private JedisPool jedisPool;
    @Test
    public void saveUser(){
        Jedis jedis = jedisPool.getResource();
        User user = new User(2,"郑州");
        Schema<User> schema = RuntimeSchema.getSchema(User.class);

        byte[] bytes = ProtostuffIOUtil.toByteArray(user,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        jedis.set("user:8".getBytes(),bytes);
        jedis.close();
    }
    @Test
    public void getUser(){
        Jedis jedis = jedisPool.getResource();
        User user = new User();

        byte[] bytes = jedis.get("user:8".getBytes());
        Schema<User> userSchema = RuntimeSchema.getSchema(User.class);

        ProtostuffIOUtil.mergeFrom(bytes,user,userSchema);
        System.out.println(user);
        jedis.close();
    }
}
