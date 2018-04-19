package cn.jyuyang.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {
    /**
     * 登录页面
     * @return
     */
    @GetMapping("/")
    public  String login(){
        return "login";
    }

    /**
     * 登记售票点以及账号信息
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
