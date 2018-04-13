package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.service.RolesPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 权限管理控制器
 * @author jyang
 *@date 2018.4.13
 */
@Controller
@RequestMapping("/manage/permission")
public class PermissionController {
    @Autowired
    private RolesPermissionService rolesPermissionService;
    @GetMapping("/home")
    public String home(Model model){
        List<Permission> permissionList = rolesPermissionService.findAllPermission();
        model.addAttribute("permissionList",permissionList);
        return "manage/permission/home";
    }


    @GetMapping("/new")
    public String addNew(Model model){
        List<Permission> permissionList = rolesPermissionService.findPermissionByType();
        model.addAttribute("permissionList",permissionList);

        return "manage/permission/new";
    }
    @PostMapping("/new")
    public String addNew(Permission permission, RedirectAttributes redirectAttributes){
        rolesPermissionService.save(permission);
        redirectAttributes.addFlashAttribute("message","新增成功");
        return "redirect:/manage/permission/home";
    }
}
