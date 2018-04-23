package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.TicketOut;
import cn.jyuyang.tms.entity.TicketOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketOutMapper {
    long countByExample(TicketOutExample example);

    int deleteByExample(TicketOutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketOut record);

    int insertSelective(TicketOut record);

    List<TicketOut> selectByExample(TicketOutExample example);

    TicketOut selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketOut record, @Param("example") TicketOutExample example);

    int updateByExample(@Param("record") TicketOut record, @Param("example") TicketOutExample example);

    int updateByPrimaryKeySelective(TicketOut record);

    int updateByPrimaryKey(TicketOut record);
}