package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.Ticket;
import com.github.pagehelper.PageInfo;

public interface TicketService {
    /**
     * 分页查询年票信息
     * @param pageNo
     * @return
     */
 PageInfo<Ticket> findTicketByPage(Integer pageNo);


 }