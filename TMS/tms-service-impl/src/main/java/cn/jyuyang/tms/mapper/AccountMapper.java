package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.Account;
import cn.jyuyang.tms.entity.AccountExample;
import java.util.List;

import cn.jyuyang.tms.entity.Roles;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    List<Roles> findRolesByAccountId(Integer id);
    /**
     * 增加，得到account信息，包括所属的角色
     * @param example
     * @return
     */
    List<Account> selectAccountAndRoles(AccountExample example);

    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}