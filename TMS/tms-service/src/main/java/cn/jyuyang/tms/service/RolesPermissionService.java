package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.entity.Roles;

import java.util.List;

/**
 * 处理permission控制器的业务实现
 * @author jyang
 */
public interface RolesPermissionService {
    /**
     * 保存新增加的权限
     * @param permission
     */
    void save(Permission permission);

    /**
     * 获得菜单类型常量，根据常量查询permission集合
     * @return
     */
    List<Permission> findPermissionByType();

    /**
     *
     * @return数据库所有permission类型的集合
     */
    List<Permission> findAllPermission();

    /**
     * 保存角色信息以及角色-权限的关系，因此还需要进行事务处理
     * @param roles
     * @param permissionId
     */
    void saveRolesAndRolesPermissionKey(Roles roles, Integer[] permissionId);

    /**
     *
     * @return 角色集合
     */
    List<Roles> findAllRoles();

    /**
     * 查找角色以及对应的权限
     * @return
     */
    List<Roles> findRolesByPermission();
}
