package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.dto.ResponseBean;
import cn.jyuyang.tms.entity.Customer;
import cn.jyuyang.tms.entity.Sales;
import cn.jyuyang.tms.entity.StoreAccount;
import cn.jyuyang.tms.entity.Ticket;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.service.SaleService;
import cn.jyuyang.tms.service.TicketService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 年票销售控制器
 */
@Controller
public class SalesController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private TicketService ticketService;
    @GetMapping("/")
    public String login(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()) {
            subject.logout();
        }
        if(subject.isRemembered()){
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/sale/ticket")
    public String saleTicket(){
        return "sale/ticket";
    }

  @PostMapping("/")
    public  String login(String mobile,
                         String password,
                         String remember,
                         HttpServletRequest request,
                         RedirectAttributes redirectAttributes) {

        Subject subject = SecurityUtils.getSubject();
        String loginIp =request.getRemoteAddr();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(mobile, DigestUtils.md5Hex(password),remember!=null,loginIp);
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

    @GetMapping("/home")
    public String saleHome(){
        return "home";
    }

    @GetMapping("/sale/new")
    public String newSales(){
        return "sale/new";
    }
    @PostMapping("/sale/new")
    public String saleHome(Customer customer, Sales sales,RedirectAttributes redirectAttributes){

        Subject subject = SecurityUtils.getSubject();
        StoreAccount storeAccount = (StoreAccount) subject.getPrincipal();
        sales.setSaleStoreId(storeAccount.getStoreSciketId());
        try {
            saleService.saveCustomerAndSales(customer, sales);
            return "redirect:/sale/list";
        }catch (ServiceException ex) {
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            return "redirect:/sale/list";
        }

    }

    @GetMapping("/sale/list")
    public String list(@RequestParam(name = "p",defaultValue = "1",required = false) Integer p,
                       @RequestParam(name = "username",defaultValue = "",required = false) String username,
                       @RequestParam(name = "mobile",defaultValue = "",required = false) String mobile,
                       Model model){
        System.out.println(username+"--------------------------");
        System.out.println(mobile+"--------------------------");
        PageInfo<Sales> salesPageInfo = saleService.findALLSales(p, username, mobile);
        model.addAttribute("salesPageInfo",salesPageInfo);
        return "sale/list";
    }
    @GetMapping("/sale/pay")
    public String payList(@RequestParam(name = "p",defaultValue = "1",required = false) Integer p,
                          @RequestParam(name = "username",defaultValue = "",required = false) String username,
                          @RequestParam(name = "mobile",defaultValue = "",required = false) String mobile,
                          Model model){
        PageInfo<Sales> salesPageInfo = saleService.findALLSales(p, username, mobile);
        model.addAttribute("salesPageInfo",salesPageInfo);
        return "sale/pay";
    }

    @GetMapping("/sale/{id:\\d+}/pay")
    @ResponseBody
    public ResponseBean payById(@PathVariable Integer id){
        try{
            saleService.payById(id);
            return ResponseBean.success();
        }catch (ServiceException ex) {
            return ResponseBean.error(ex.getMessage());
        }


    }

    @GetMapping("/sale/{id:\\d+}/del")
    public ResponseBean delById(@PathVariable Integer id){
        try {
            saleService.deleteById(id);
            return ResponseBean.success();
        }catch (ServiceException ex) {
            return ResponseBean.error(ex.getMessage());
        }
    }
    @GetMapping("/sale/ticket/lose")
    public String lose(@RequestParam(defaultValue = "1",name = "p",required = false) Integer p,
                       @RequestParam(defaultValue = "",name = "username",required = false) String username,
                       @RequestParam(defaultValue = "",name = "mobile",required = false) String mobile,
                                   Model model){


        PageInfo<Sales> salesPageInfo = saleService.findALLSales(p,username,mobile);
        model.addAttribute("salesPageInfo",salesPageInfo);
        return "sale/lose";
    }
    @GetMapping("/sale/ticket/{ticketnum}/update")
    public String updateState(@PathVariable String ticketnum,Model model){
        try {
            Ticket ticket = ticketService.seleteByTicketNum(ticketnum);
            model.addAttribute("ticekt", ticket);
            return "sale/ticket";

        }catch (ServiceException ex){
            return "error/401";
        }

    }

    @GetMapping("/sale/{id:\\d+}/lose")
    @ResponseBody
    public ResponseBean loseById(@PathVariable Integer id) {
        try{
            saleService.loseById(id);
            return ResponseBean.success();
        }catch (ServiceException ex) {
            return ResponseBean.error(ex.getMessage());
        }
    }
    @GetMapping("/sale/tongji")
    public String tongji(){
        return "sale/tongji";
    }
}
