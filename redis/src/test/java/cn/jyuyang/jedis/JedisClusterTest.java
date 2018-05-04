package cn.jyuyang.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis-cluster.xml")*/
public class JedisClusterTest {

//    @Autowired
//    private JedisCluster jedisCluster;
    @Test
    public void save(){
       GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMinIdle(5);

        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();

        hostAndPortSet.add(new HostAndPort("192.168.1.195",6004));
        hostAndPortSet.add(new HostAndPort("192.168.1.195",6003));
        hostAndPortSet.add(new HostAndPort("192.168.1.196",6005));
        hostAndPortSet.add(new HostAndPort("192.168.1.196",6006));
        hostAndPortSet.add(new HostAndPort("192.168.1.197",6007));
        hostAndPortSet.add(new HostAndPort("192.168.1.197",6008));
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet,poolConfig);
        jedisCluster.set("name","tom");
        System.out.println(jedisCluster.get("name"));

    }

  /*  @Test
    public void getName(){
        System.out.println(jedisCluster.get("name"));
    }
*/
}
