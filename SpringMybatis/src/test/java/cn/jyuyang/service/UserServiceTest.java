package cn.jyuyang.service;

import cn.jyuyang.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void fingdById(){
        User user = userService.findById(3);
        System.out.println(user);

    }
}
