package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.Ticket;
import cn.jyuyang.tms.entity.TicketExample;
import cn.jyuyang.tms.entity.TicketInLog;
import cn.jyuyang.tms.entity.TicketInLogExample;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.mapper.TicketInLogMapper;
import cn.jyuyang.tms.mapper.TicketMapper;
import cn.jyuyang.tms.service.TicketInLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketInLogServiceImpl implements TicketInLogService {
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private TicketInLogMapper ticketInLogMapper;
    /**
     * 保存新建的入库记录
     *
     * @param ticketInLog
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveTicketInlog(TicketInLog ticketInLog) {

        ticketInLog.setCreateTime(new Date());
        BigInteger beginNum = new BigInteger(ticketInLog.getStartNum());
        BigInteger endNum = new BigInteger(ticketInLog.getEndNum());
        BigInteger totalNum = endNum.subtract(beginNum).add(new BigInteger(String.valueOf(1)));

        TicketInLogExample ticketInLogExample = new TicketInLogExample();
        List<TicketInLog> ticketInLogList = ticketInLogMapper.selectByExample(ticketInLogExample);
        boolean flag = true;

        for(TicketInLog inLog : ticketInLogList) {
            if((beginNum.intValue() >= Integer.valueOf(inLog.getStartNum()) &&
                    beginNum.intValue() <= Integer.valueOf(inLog.getEndNum())) ||
                    (endNum.intValue()>=Integer.valueOf(inLog.getStartNum()) && endNum.intValue()<=Integer.valueOf(inLog.getEndNum()))){
                flag = false;
            }
        }

        if(flag) {
            ticketInLog.setTotalNum(totalNum.toString());

            ticketInLogMapper.insertSelective(ticketInLog);
            List<Ticket> ticketList = new ArrayList<>();

            for (int i = 0; i < totalNum.intValue(); i++) {
                Ticket ticket = new Ticket();
                ticket.setCreateTime(new Date());
                ticket.setTicketInTime(new Date());
                ticket.setTicketState(Ticket.TICKET_STATE_NORMAL);
                ticket.setTicketNum(beginNum.add(new BigInteger(String.valueOf(i))).toString());
                ticketList.add(ticket);
            }
            ticketMapper.insertTicketList(ticketList);
        }else{
            throw new ServiceException("票号有冲突，请核对后重试！");
        }
    }

    /**
     * 查找所有年票入库记录
     *
     * @return
     */
    @Override
    public List<TicketInLog> findAllTicket() {

        TicketInLogExample logExample = new TicketInLogExample();
        return ticketInLogMapper.selectByExample(logExample);

    }

    /**
     * 根据ID查询对应的记录信息
     *
     * @param id
     * @return
     */
    @Override
    public TicketInLog selectById(Integer id) {

        return ticketInLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据ID删除记录和年票信息
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteTicketInLogAndTicketById(Integer id) {

        TicketInLog ticketInLog = ticketInLogMapper.selectByPrimaryKey(id);
        if(ticketInLog != null) {
            String startNum = ticketInLog.getStartNum();
            String endNum = ticketInLog.getEndNum();

            TicketExample ticketExample = new TicketExample();
            ticketExample.createCriteria().andTicketNumBetween(startNum, endNum);

            ticketMapper.deleteByExample(ticketExample);

            ticketInLogMapper.deleteByPrimaryKey(id);
        }else{
            throw new ServiceException("参数异常！！！");
        }
    }
}
