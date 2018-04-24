package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.*;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.mapper.TicketMapper;
import cn.jyuyang.tms.mapper.TicketOutMapper;
import cn.jyuyang.tms.service.TicketOutservice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class TicketOutServiceImpl implements TicketOutservice{
    @Autowired
    private TicketOutMapper ticketOutMapper;
    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 查找所有的下发记录信息
     *
     * @return
     */
    @Override
    public List<TicketOut> findAllTicketOut() {
        TicketOutExample ticketOutExample = new TicketOutExample();
        ticketOutExample.setOrderByClause("id desc");
        return ticketOutMapper.selectByExample(ticketOutExample);

    }

    /**
     * 保存下发信息
     *
     * @param ticketOut
     */
    @Override
    @Transactional(rollbackFor= RuntimeException.class)
    public void saveTicketOut(TicketOut ticketOut) {

        BigInteger start = new BigInteger(ticketOut.getOutStartTicket());
        BigInteger end = new BigInteger(ticketOut.getOutEndTicket());
        Integer totalTemp = end.subtract(start).add(new BigInteger(String.valueOf(1))).intValue();

        if(totalTemp <= 0) {
           throw new ServiceException("输入的票号区间有问题，请核对后重试！");
        }

        List<Ticket> ticketList = ticketMapper.selectBetweenStartAndEnd(ticketOut.getOutStartTicket(),ticketOut.getOutEndTicket());
        for(Ticket ticket : ticketList) {
            if(!ticket.getTicketState().equals(Ticket.TICKET_STATE_NORMAL)){
                throw new ServiceException("有部分票号无法使用！");
            }
        }

        TicketExample startTicketExample = new TicketExample();
        startTicketExample.createCriteria().andTicketNumEqualTo(ticketOut.getOutStartTicket());
         TicketExample endTicketExample = new TicketExample();
        endTicketExample.createCriteria().andTicketNumEqualTo(ticketOut.getOutEndTicket());

        if(ticketMapper.selectByExample(startTicketExample).size() == 0 || ticketMapper.selectByExample(endTicketExample).size() == 0){
            throw new ServiceException("部分票号不存在！");
        }


        Integer totalNum = ticketList.size();

        BigDecimal totalPrice =  ticketOut.getOnePrice().multiply(new BigDecimal(totalNum));
        Subject subject =SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();

        ticketOut.setOutTime(new Date());
        ticketOut.setContent(ticketOut.getOutStartTicket() +"--"+ticketOut.getOutEndTicket());
        ticketOut.setTotalPrice(totalPrice);
        ticketOut.setOutNum(totalNum);
        ticketOut.setOutState(TicketOut.NO_TICKET_PAY);
        ticketOut.setOutAccount(account.getUsername());
        ticketOutMapper.insertSelective(ticketOut);
    }

    /**
     * 删除对应的下发记录
     *
     * @param id
     */
    @Override
    public void delTicketOutById(Integer id) {
        TicketOut ticketOut = ticketOutMapper.selectByPrimaryKey(id);
        if(ticketOut == null){
            throw new ServiceException("参数错误！！！");
        }

        if(TicketOut.TICKET_PAY.equals(ticketOut.getOutState())){
            throw new ServiceException("该记录已经支付，不能删除");
        }

        ticketOutMapper.deleteByPrimaryKey(id);


    }

    /**
     * 支付id下发的记录
     *
     * @param id
     */
    @Override
    public void payById(Integer id) {
        TicketOut ticketOut = ticketOutMapper.selectByPrimaryKey(id);
        if(ticketOut != null && ticketOut.getOutState().equals(TicketOut.NO_TICKET_PAY)) {
            ticketOut.setOutState(TicketOut.TICKET_PAY);
            ticketOutMapper.updateByPrimaryKey(ticketOut);
        }else{
            throw new ServiceException("参数错误");
        }
    }
}
