package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.entity.PermissionExample;
import cn.jyuyang.tms.mapper.PermissionMapper;
import cn.jyuyang.tms.service.RolesPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 权限服务层的实现类
 * @author jyang
 */
@Service
public class RolesPermissionServiceImpl implements RolesPermissionService{
    public static final Logger logger = LoggerFactory.getLogger(RolesPermissionServiceImpl.class);
    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 保存新增加的权限
     *
     * @param permission
     */
    @Override
    public void save(Permission permission) {
        permission.setCreateTime(new Date());
        permissionMapper.insertSelective(permission);
        logger.info("添加权限{}",permission);
    }

    /**
     * 获得菜单类型常量，根据常量查询permission集合
     *
     * @return
     */
    @Override
    public List<Permission> findPermissionByType() {
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPermissionTypeEqualTo(Permission.MENU_PERMISSION);
        return permissionMapper.selectByExample(permissionExample);
    }

    /**
     * @return数据库所有permission类型的集合
     */
    @Override
    public List<Permission> findAllPermission() {
        PermissionExample permissionExample = new PermissionExample();
       // permissionExample.setOrderByClause("parent_id desc");
        
        return permissionMapper.selectByExample(permissionExample);
    }
}
