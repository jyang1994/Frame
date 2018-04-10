package cn.jyuyang.controller;

import cn.jyuyang.entity.User;
import cn.jyuyang.exception.NotFountException;
import cn.jyuyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{id:\\d+}")
    public String findById(@PathVariable Integer id, Model model){
        System.out.println(id);
        User user = userService.findById(id);
        if(user == null) {
            throw new NotFountException();
        }
        model.addAttribute("user",user);
        return "User/user";
    }
    @GetMapping
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "User/userlist";
    }
}
