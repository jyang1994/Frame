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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis-cluster.xml")
public class JedisClusterTest {

    @Autowired
    private JedisCluster jedisCluster;
    @Test
    public void save(){
       /* GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMinIdle(5);

        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();

        hostAndPortSet.add(new HostAndPort("192.168.137.169",6001));
        hostAndPortSet.add(new HostAndPort("192.168.137.169",6002));
        hostAndPortSet.add(new HostAndPort("192.168.137.169",6003));
        hostAndPortSet.add(new HostAndPort("192.168.137.169",6004));
        hostAndPortSet.add(new HostAndPort("192.168.137.169",6005));
        hostAndPortSet.add(new HostAndPort("192.168.137.169",6006));
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet,poolConfig);
        jedisCluster.set("name","tom");
        System.out.println(jedisCluster.get("name"));*/

    }

    @Test
    public void getName(){
        System.out.println(jedisCluster.get("name"));
    }

}
