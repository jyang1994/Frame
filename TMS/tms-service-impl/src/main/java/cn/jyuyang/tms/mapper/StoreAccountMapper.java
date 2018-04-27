package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.StoreAccount;
import cn.jyuyang.tms.entity.StoreAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreAccountMapper {

    StoreAccount findAccountWithStore(String mobile);

    long countByExample(StoreAccountExample example);

    int deleteByExample(StoreAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreAccount record);

    int insertSelective(StoreAccount record);

    List<StoreAccount> selectByExample(StoreAccountExample example);

    StoreAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreAccount record, @Param("example") StoreAccountExample example);

    int updateByExample(@Param("record") StoreAccount record, @Param("example") StoreAccountExample example);

    int updateByPrimaryKeySelective(StoreAccount record);

    int updateByPrimaryKey(StoreAccount record);
}