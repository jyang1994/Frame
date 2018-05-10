package cn.jyuyang.controller;

import cn.jyuyang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private UserDao userDao;
    @GetMapping("/home")
    public String home (){

//        userDao.save("jjjmd");
        return "home";
    }
}
