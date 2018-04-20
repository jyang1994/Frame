package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.TicketInLog;

import java.util.List;

public interface TicketInLogService {
    /**
     * 保存新建的入库记录
     * @param ticketInLog
     */
    void saveTicketInlog(TicketInLog ticketInLog);

    /**
     * 查找所有年票入库记录
     * @return
     */
    List<TicketInLog> findAllTicket();

    /**
     * 根据ID查询对应的记录信息
     * @param id
     * @return
     */
    TicketInLog selectById(Integer id);

    /**
     * 根据ID删除记录和年票信息
     * @param id
     */
    void deleteTicketInLogAndTicketById(Integer id);
}
