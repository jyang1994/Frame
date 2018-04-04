

import cn.jyuyang.entity.User;
import cn.jyuyang.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import java.util.List;

public class MapperTest {


    @Test
    public void findByIdTest() throws Exception{

        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);

        User user = sqlSession.selectOne("cn.jyuyang.mapper.UserMapper.findById",1);
        System.out.println(user);
        sqlSession.close();

    }
    @Test
    public void findAllTest() throws Exception{


        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);

        List<User> users = sqlSession.selectList("cn.jyuyang.mapper.UserMapper.findAll");
       for (User user : users){
           System.out.println(user);
       }

        sqlSession.close();

    }

}
