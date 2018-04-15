package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.entity.RolesPermissionExample;
import cn.jyuyang.tms.entity.RolesPermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesPermissionMapper {
    List<RolesPermissionKey> selectByPermissionId(Integer id);
    long countByExample(RolesPermissionExample example);

    int deleteByExample(RolesPermissionExample example);

    int deleteByPrimaryKey(RolesPermissionKey key);

    int insert(RolesPermissionKey record);

    int insertSelective(RolesPermissionKey record);

    List<RolesPermissionKey> selectByExample(RolesPermissionExample example);

    int updateByExampleSelective(@Param("record") RolesPermissionKey record, @Param("example") RolesPermissionExample example);

    int updateByExample(@Param("record") RolesPermissionKey record, @Param("example") RolesPermissionExample example);
}