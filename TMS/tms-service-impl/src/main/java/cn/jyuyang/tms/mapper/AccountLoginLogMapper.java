package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.AccountLoginLog;
import cn.jyuyang.tms.entity.AccountLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountLoginLogMapper {
    long countByExample(AccountLoginLogExample example);

    int deleteByExample(AccountLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountLoginLog record);

    int insertSelective(AccountLoginLog record);

    List<AccountLoginLog> selectByExample(AccountLoginLogExample example);

    AccountLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountLoginLog record, @Param("example") AccountLoginLogExample example);

    int updateByExample(@Param("record") AccountLoginLog record, @Param("example") AccountLoginLogExample example);

    int updateByPrimaryKeySelective(AccountLoginLog record);

    int updateByPrimaryKey(AccountLoginLog record);
}