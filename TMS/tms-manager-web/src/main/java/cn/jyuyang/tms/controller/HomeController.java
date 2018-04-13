package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.entity.Account;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录系统管理
 * @author jyang
 */
@Controller
public class HomeController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/")
    public  String login(String username, String password,
                         HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) {
        String loginIp = request.getRemoteAddr();
        try {
            Account account = accountService.login(username, password, loginIp);
            session.setAttribute("account", account);
            redirectAttributes.addFlashAttribute("account",account);
            return "redirect:/home";
        } catch (ServiceException e) {
            redirectAttributes.addFlashAttribute("username", username);
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/";
        }
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/")
    public  String login(){
        return "login";
    }
}
