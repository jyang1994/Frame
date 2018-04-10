package cn.jyuyang.controller;

import cn.jyuyang.entity.User;
import cn.jyuyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id:\\d+}")
    public String findById(@PathVariable Integer id, Model model){
        System.out.println(id);
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "User/user";
    }
}
