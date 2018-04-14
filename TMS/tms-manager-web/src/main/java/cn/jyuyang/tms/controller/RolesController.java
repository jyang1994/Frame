package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.entity.Roles;
import cn.jyuyang.tms.service.RolesPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manage/roles")
public class RolesController {
    @Autowired
    private RolesPermissionService rolesPermissionService;

    @GetMapping("/home")
    public String home(Model model){

        List<Roles> rolesList = rolesPermissionService.findRolesByPermission();
        for(Roles roles : rolesList){
            System.out.println(roles.getRolesPermissionKeyList());

        }
        model.addAttribute("rolesList",rolesList);
        return "manage/roles/home";
    }

    /**
     * @return 跳转到添加页面
     */
    @GetMapping("/new")
    public String newRoles(Model model){
       List<Permission> permissionList = rolesPermissionService.findAllPermission();
       model.addAttribute("permissionList",permissionList);
        return "manage/roles/new";
    }
    @PostMapping("/new")
    public String newRoles(Roles roles, Integer[] permissionId){
        rolesPermissionService.saveRolesAndRolesPermissionKey(roles,permissionId);
        return "redirect:/manage/roles/home";
    }
}
