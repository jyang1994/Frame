package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.entity.Roles;
import cn.jyuyang.tms.entity.RolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMapper {
    /**
     * @return 权限对象
     */
    List<Roles> findPermissionByRoles(RolesExample example);
    long countByExample(RolesExample example);

    int deleteByExample(RolesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    List<Roles> selectByExample(RolesExample example);

    Roles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByExample(@Param("record") Roles record, @Param("example") RolesExample example);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    Roles findRolesAndPermissionById(Integer id);

    List<Roles> findRolesByAccountId(Integer id);
}