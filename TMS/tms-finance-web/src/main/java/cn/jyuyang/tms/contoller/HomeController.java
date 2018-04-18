package cn.jyuyang.tms.contoller;

import cn.jyuyang.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录系统管理
 * @author jyang
 */
@Controller
public class HomeController {
    @Autowired
    private AccountService accountService;
    /**
     * 登录界面
     * @return
     */
    @GetMapping("/")
    public  String login(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }
        if(subject.isRemembered()){
            return "redirect:/home";
        }
        return "login";
    }

    /**
     * 登录提交
     * @param username
     * @param password
     * @param remember
     * @param request
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/")
    public  String login(String username,
                         String password,
                         String remember,
                         HttpServletRequest request,
                         RedirectAttributes redirectAttributes) {
        Subject subject = SecurityUtils.getSubject();
        String loginIp =request.getRemoteAddr();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(username, DigestUtils.md5Hex(password),remember!=null,loginIp);
        try{
            subject.login(usernamePasswordToken);

            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/home";


            if(savedRequest != null) {
                url=savedRequest.getRequestUrl();
            }
            return "redirect:"+url;
        }catch (UnknownAccountException |IncorrectCredentialsException ex){
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","帐号或者密码错误");
        }catch (LockedAccountException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","帐号被锁定");
        }catch (AuthenticationException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","帐号或者密码错误");
        }
        return "redirect:/";
    }

    /**
     * 后台管理首页
     * @return
     */
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    /**
     * 401没有权限
     */
    @GetMapping("/401")
    public String unauthorizedUrl() {
        return "error/401";
    }

}
