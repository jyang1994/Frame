package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.Ticket;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface TicketService {
    /**
     * 分页查询年票信息
     * @param pageNo
     * @return
     */
    PageInfo<Ticket> findTicketByPage(Integer pageNo,String ticketNum);

    /**
     * 统计年票数量，以状态分类
     * @return
     */
    Map<String,Long> findTongJiByState();

    /**
     * 根据ID把票的状态修改成作废
     * @param id
     */
    void invalidById(Integer id);
}