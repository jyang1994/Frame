package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.Permission;

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
}
