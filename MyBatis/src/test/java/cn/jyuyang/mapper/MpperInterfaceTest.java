package cn.jyuyang.mapper;

import cn.jyuyang.entity.User;
import cn.jyuyang.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MpperInterfaceTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    @Before
    public void init() {
        // 自动提交事务
        sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        // 动态代理 动态生成
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("赵小蓝11");
        user.setAddress("北京");
        user.setTel("0107727");

        int num = userMapper.save(user);
        System.out.println("受影响的行数：" + num);
        int id = user.getId();
        System.out.println("自动生成的id：" + id);
    }
    @Test
    public void findAllTest(){
        List<User> users = userMapper.findAll();
        for(User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testFindPage2() {
       Map map = new HashMap<String, Integer>();
       map.put("start", 0);
       map.put("size", 5);
       List<User> userList = userMapper.page2(map);
       for (User user : userList) {
          System.out.println(user);
       }
   }
    @Test
    public void testFindPage() {
        List<User> userList = userMapper.page(0,3);
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
