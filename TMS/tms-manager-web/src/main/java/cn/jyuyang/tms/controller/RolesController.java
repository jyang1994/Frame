package cn.jyuyang.tms.controller;

import cn.jyuyang.tms.dto.ResponseBean;
import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.entity.Roles;
import cn.jyuyang.tms.entity.RolesPermissionKey;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.service.RolesPermissionService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/roles")
public class RolesController {
    @Autowired
    private RolesPermissionService rolesPermissionService;

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delRoles(@PathVariable Integer id){
        try{
            rolesPermissionService.delRolesById(id);
            return ResponseBean.success();
        }catch (ServiceException ex){
            return ResponseBean.success(ex.getMessage());
        }
    }

    @PostMapping("/{id:\\d+}/edit")
    public String editRoles(Roles roles,Integer[] permissionId ){
        rolesPermissionService.updateRolesAndRolesPermissionKey(roles,permissionId);
        return "redirect:/manage/roles/home";
    }
    @GetMapping("/{id:\\d+}/edit")
    public String editRoles(@PathVariable Integer id,Model model){

        Roles roles = rolesPermissionService.findRolesById(id);
        List<Permission> permissionList = rolesPermissionService.findAllPermission();

        Map<Permission,Boolean> permissionMap = checkedRoles(roles,permissionList);

        model.addAttribute("roles",roles);
        model.addAttribute("permissionMap",permissionMap);
        return "manage/roles/edit";
    }

    /**
     * 私有工具方法，解决角色原有的权限选择打钩问题
     * @param roles
     * @param permissionList
     * @return
     */
    private Map<Permission,Boolean> checkedRoles(Roles roles, List<Permission> permissionList) {


        Map<Permission,Boolean> rolesBooleanMap = Maps.newLinkedHashMap();

        List<RolesPermissionKey> rolesPermissionKeys = roles.getRolesPermissionKeyList();


        for (Permission permission:permissionList){
            boolean flag = false;
            for(RolesPermissionKey rolesPermissionKey : rolesPermissionKeys){

               if(permission.getId().equals(rolesPermissionKey.getPermissionId())) {
                   flag = true;
                   break;
               }
            }
            rolesBooleanMap.put(permission,flag);
        }
        return rolesBooleanMap;
    }

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
        System.out.println(roles.getRoleName()+"---------------------------");
        rolesPermissionService.saveRolesAndRolesPermissionKey(roles,permissionId);
        return "redirect:/manage/roles/home";
    }
}
