package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.dto.ResponseBean;
import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.service.RolesPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.rmi.server.ServerCloneException;
import java.util.Date;
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

    @PostMapping("/{id:\\d+}/edit")
    public String edit(Permission permission){

        permission.setCreateTime(new Date());
        rolesPermissionService.updatePermission(permission);
        return "redirect:/manage/permission/home";
    }

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean del(@PathVariable Integer id){
        try {
            rolesPermissionService.delPermissionById(id);
            return ResponseBean.success();
        }catch (ServiceException ex){
            return ResponseBean.error(ex.getMessage());
        }
    }

    @GetMapping("/{id:\\d+}/edit")
    public String edit(@PathVariable Integer id,Model model){
        try {
            Permission permission = rolesPermissionService.findPermissionById(id);
            model.addAttribute("permission",permission);
            return "manage/permission/edit";
        }catch (ServiceException ex) {
            throw new Error("404");
        }
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
