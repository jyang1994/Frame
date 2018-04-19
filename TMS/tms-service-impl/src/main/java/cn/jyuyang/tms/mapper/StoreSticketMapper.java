package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.StoreSticket;
import cn.jyuyang.tms.entity.StoreSticketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreSticketMapper {
    long countByExample(StoreSticketExample example);

    int deleteByExample(StoreSticketExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreSticket record);

    int insertSelective(StoreSticket record);

    List<StoreSticket> selectByExample(StoreSticketExample example);

    StoreSticket selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreSticket record, @Param("example") StoreSticketExample example);

    int updateByExample(@Param("record") StoreSticket record, @Param("example") StoreSticketExample example);

    int updateByPrimaryKeySelective(StoreSticket record);

    int updateByPrimaryKey(StoreSticket record);
}