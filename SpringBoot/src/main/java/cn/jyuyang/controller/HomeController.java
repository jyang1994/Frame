package cn.jyuyang.controller;

import cn.jyuyang.activemq.MQQueue;
import cn.jyuyang.activemq.MQTopic;
import cn.jyuyang.dao.UserDao;
import cn.jyuyang.entity.User;
import cn.jyuyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private MQQueue mqQueue;
    @Autowired
    private MQTopic mqTopic;

    @GetMapping("/home/{id:\\d+}")
    public User home (@PathVariable Integer id){

    User user = userService.findById(id);
//        userDao.save("jjjmd");
        return user;
    }



    @GetMapping("/hello")
    public String  hello(){
        mqQueue.sendMessageToQueue("hello2");
        return "hello.1";
    }
}
