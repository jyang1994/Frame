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

    /**
     * 根据id对应的权限
     * @param id
     * @return 权限的实体对象
     */
    Permission findPermissionById(Integer id);

    /**
     * 更新权限对象
     * @param permission
     */
    void updatePermission(Permission permission);

    /**
     * 根据id删除对应的权限
     * 需要判断id是否作为父权限和是否权限正在使用
     * @param id
     */
    void delPermissionById(Integer id);

    /**
     * 根据id查找对应的Roles对象，包括对应的权限集合
     * @param id
     * @return
     */
    Roles findRolesById(Integer id);

    /**
     * 更新角色以及所拥有的权限
     * @param roles
     * @param permissionId
     */
    void updateRolesAndRolesPermissionKey(Roles roles, Integer[] permissionId);

    /**
     * 根据id删除对应的角色对象
     * @param id
     */
    void delRolesById(Integer id);
}
