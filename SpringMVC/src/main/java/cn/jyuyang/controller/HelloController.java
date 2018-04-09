package cn.jyuyang.controller;

import cn.jyuyang.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class HelloController {

    @GetMapping("/all.json")
    public @ResponseBody List<Customer> showAllCustomer() {
        List<Customer> customerList = Arrays.asList(
                new Customer(1001,"lisi","北京"),
                new Customer(1002,"wangwu","上海"),
                new Customer(1006,"Hanmeili","开封")
        );
        return customerList;
    }

    @GetMapping(value = "/find",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public  String ajaxSave() {
        return "查找成功";
    }


    @GetMapping
    public String list(Model model,
                       @RequestParam(name = "p",defaultValue = "1") Integer num){
        System.out.println(num);
        model.addAttribute("num",num);
        return "customer/list";
    }

    @GetMapping("/{id:.+}")
    public String hello(@PathVariable String id){
        System.out.println(id);
        return "customer/hello";
    }
    @GetMapping("/new")
    public String newCustomer(){
        return "customer/new";
    }
    @PostMapping("/new")
    public String newCustomer(Customer customer){
       System.out.println("name:"+customer.getName()+" --> address:" +customer.getAddress());
       return "redirect:/customer/new";
   }
    @GetMapping("/save")
    @ResponseBody
   public Customer save(){
        Customer customer = new Customer(1,"tom","焦作");
        return customer;
   }
  /*  @PostMapping("/new")
    public String newCustomer(String name,String address){
        System.out.println("name:"+name+"address:" +address);
        return "redirect:/customer/new";
    }*/
    @GetMapping("/{id:\\d+}")
    public ModelAndView delCustomer(@PathVariable Integer id){
        System.out.println(id);
        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("id",id);
        return modelAndView;
    }


}
