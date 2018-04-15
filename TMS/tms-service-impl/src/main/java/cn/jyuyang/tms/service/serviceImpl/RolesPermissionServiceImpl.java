package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.*;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.mapper.PermissionMapper;
import cn.jyuyang.tms.mapper.RolesMapper;
import cn.jyuyang.tms.mapper.RolesPermissionMapper;
import cn.jyuyang.tms.service.RolesPermissionService;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.util.ArrayList;
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
    public PermissionMapper permissionMapper;

    @Autowired
    private RolesMapper rolesMapper;

    @Autowired
    private RolesPermissionMapper rolesPermissionMapper;

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
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        List<Permission> resList = new ArrayList<>();
        permissionListUtil(permissionList,resList,0);
        return resList;
    }

    /**
     * 保存角色信息以及角色-权限的关系，因此还需要进行事务处理
     *
     * @param roles
     * @param permissionId
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveRolesAndRolesPermissionKey(Roles roles, Integer[] permissionId) {
        roles.setCreateTime(new Date());
        rolesMapper.insertSelective(roles);
        for(Integer id : permissionId){
            RolesPermissionKey rolesPermissionKey = new RolesPermissionKey();
            rolesPermissionKey.setRolesId(roles.getId());
            rolesPermissionKey.setPermissionId(id);
            rolesPermissionMapper.insert(rolesPermissionKey);
        }
    }

    /**
     * @return 角色集合
     */
    @Override
    public List<Roles> findAllRoles() {
        RolesExample rolesExample = new RolesExample();

      return rolesMapper.selectByExample(rolesExample);

    }

    /**
     * 查找角色以及对应的权限
     *
     * @return
     */
    @Override
    public List<Roles> findRolesByPermission() {
        RolesExample rolesExample = new RolesExample();

        return rolesMapper.findPermissionByRoles(rolesExample);
    }

    /**
     * 根据id对应的权限
     *
     * @param id
     * @return 权限的实体对象
     */
    @Override
    public Permission findPermissionById(Integer id) {

       Permission permission = permissionMapper.selectByPrimaryKey(id);

        if (permission == null) {
            throw new ServiceException("不存在该权限");
        }

        return permission;

    }

    /**
     * 更新权限对象
     *
     * @param permission
     */
    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updateByPrimaryKey(permission);
    }

    /**
     * 根据id删除对应的权限
     * 需要判断id是否作为父权限和是否权限正在使用
     *
     * @param id
     */
    @Override
    public void delPermissionById(Integer id) {
        List<RolesPermissionKey> rolesPermissionKeys = rolesPermissionMapper.selectByPermissionId(id);

        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andParentIdEqualTo(id);
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);

        if(permissionList.size()!=0){
            throw new ServiceException("该权限作为父权限存在，暂无法删除！");
        }
        if(rolesPermissionKeys.size()!=0) {
            throw new ServiceException("该权限已被角色使用，暂无法删除！");
        }

        permissionMapper.deleteByPrimaryKey(id);
    }


    /**
     * 对数组进行递归规律，让兄弟类排在一起
     * @param inList
     * @param outList
     * @param parentId
     */
   private void permissionListUtil(List<Permission> inList,List<Permission> outList,int parentId ){
        List<Permission> tempList = Lists.newArrayList(Collections2.filter(inList, permission -> permission.getParentId().equals(parentId)));
        for(Permission permission:tempList){
            outList.add(permission);
            permissionListUtil(inList,outList,permission.getId());
        }
    }
}
