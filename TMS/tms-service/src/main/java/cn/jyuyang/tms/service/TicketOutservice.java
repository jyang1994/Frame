package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.TicketOut;

import java.util.List;

public interface TicketOutservice {
    /**
     * 查找所有的下发记录信息
     * @return
     */
    List<TicketOut> findAllTicketOut();

    /**
     * 保存下发信息
     * @param ticketOut
     */
    void saveTicketOut(TicketOut ticketOut);

    /**
     * 删除对应的下发记录
     * @param id
     */
    void delTicketOutById(Integer id);
}
