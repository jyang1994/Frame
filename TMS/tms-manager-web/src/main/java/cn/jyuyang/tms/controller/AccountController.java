package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.dto.ResponseBean;
import cn.jyuyang.tms.entity.Account;
import cn.jyuyang.tms.entity.Roles;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.service.AccountService;
import cn.jyuyang.tms.service.RolesPermissionService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private RolesPermissionService rolesPermissionService;

    /**
     * 删除账号以及存在的账号和角色关系
     * @param id
     * @return ajax
     */
    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean del(@PathVariable Integer id){
        try {
            accountService.deleteAccountAndRolesKey(id);
            return ResponseBean.success();
        }catch (ServiceException e){
            return ResponseBean.error(e.getMessage());
        }

    }
    @GetMapping("/{id:\\d+}/edit")
    public String edit(@PathVariable Integer id,Model model){
        try {
            Account acc = accountService.findAccountById(id);
            List<Roles> rolesList = rolesPermissionService.findAllRoles();
            model.addAttribute("acc",acc);
            model.addAttribute("rolesList",rolesList);
            return "manage/account/edit";
        }catch (ServiceException e){
            throw new Error("404");
        }

    }
    @PostMapping("/{id:\\d+}/edit")
    public String edit(Account account,Integer rolesId) {
        accountService.updateAccountAndRoles(account,rolesId);
        return "redirect:/manage/account/home";

    }

    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(required = false) String username,
                       @RequestParam(required = false) Integer rolesId){
        Map<String,Object> requestParam = Maps.newHashMap();
        requestParam.put("username",username);
        requestParam.put("rolesId",rolesId);

        model.addAttribute("rolesList",rolesPermissionService.findAllRoles());
        model.addAttribute("accountList",accountService.findAccountAndRoles(requestParam));
        return "manage/account/home";
    }

    @GetMapping("/new")
    public String newAccount(Model model){
        List<Roles> rolesList = rolesPermissionService.findRolesByPermission();
        model.addAttribute("rolesList",rolesList);
        return "manage/account/new";
    }

    @PostMapping("/new")
    public String newAccount(Account account, Integer rolesId, RedirectAttributes redirectAttributes){

        try {
            accountService.saveAccountAndRoles(account, rolesId);
            return "redirect:/manage/account/home";
        }catch (ServiceException e) {
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            return "manage/account/new";
        }
    }
}
