package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.Ticket;
import cn.jyuyang.tms.entity.TicketExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TicketMapper {
    Map<String,Integer> tongjiByStoreId(Integer id);

    long countByExample(TicketExample example);

    int deleteByExample(TicketExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    List<Ticket> selectByExample(TicketExample example);

    Ticket selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByExample(@Param("record") Ticket record, @Param("example") TicketExample example);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

    void insertTicketList(@Param("ticketList") List<Ticket> ticketList);

    /**
     * 查找年票以及下发到哪个售票点
     * @return
     */
    List<Ticket> selectTicketAndStore();

    /**
     * 查找票号区间
     * @param outStartTicket
     * @param outEndTicket
     * @return
     */
    List<Ticket> selectBetweenStartAndEnd(@Param("start") String outStartTicket, @Param("end") String outEndTicket);
    Map<String,Long> tongjiByState();
}