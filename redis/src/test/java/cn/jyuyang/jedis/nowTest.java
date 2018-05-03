package cn.jyuyang.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nowTest {



        Jedis jedis = new Jedis("192.168.137.168",6379);
    @Test
    public void firstString(){
        /*String pong = jedis.ping();
        System.out.println(pong);*/

        jedis.set("name:1","tom");

        jedis.incr("num:1");
        jedis.incrBy("num:2",3);
        jedis.append("name:1","aaa");

        jedis.mset("name:3","jack","name:4","sony");
        System.out.println(jedis.mget("name:1","name:3","name:4"));
        jedis.close();
    }
    @Test
    public void secondHash(){
        jedis.hset("user:1","name","tom");

        Map<String,String> maps = new HashMap<String, String>();
        maps.put("name","jack");
        maps.put("age","23");

        jedis.hmset("user:2",maps);
        List<String> lists = jedis.hvals("user:2");
       /* for(String str : lists) {
            System.out.println(str);
        }*/

        System.out.println(jedis.hlen("user:2"));
        jedis.close();
    }
    @Test
    public void thirdList(){
       /* jedis.lpush("tom:xq","tw","cg","dwj");
        jedis.rpush("tom:xq","yx");*/
      // jedis.lpop("tom:xq");
       // jedis.lrem("tom:xq",2,"tw");
        jedis.linsert("tom:xq", BinaryClient.LIST_POSITION.BEFORE,"cg","ww");
        System.out.println(jedis.lindex("tom:xq",2));
        jedis.close();
    }

    @Test
    public void fourthSet(){
        //jedis.sadd("num:6","66","88","100");
        jedis.srem("num:6","66");

        System.out.println(jedis.smembers("num:6"));
        jedis.close();
    }

    @Test
    public void fifthZset(){
        jedis.zadd("class:1",66,"tom");
        System.out.println(jedis.zrange("class:1",0,-1));
        jedis.close();
    }
    @Test
    public void pool(){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        config.setMinIdle(5);
        JedisPool jedisPool = new JedisPool("192.168.137.168",6379);

        Jedis jedisUtil =  jedisPool.getResource();
        jedis.flushAll();
        jedis.close();
    }
}
