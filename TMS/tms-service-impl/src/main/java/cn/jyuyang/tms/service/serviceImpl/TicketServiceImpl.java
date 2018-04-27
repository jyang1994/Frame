package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.Ticket;
import cn.jyuyang.tms.entity.TicketExample;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.mapper.TicketMapper;
import cn.jyuyang.tms.service.TicketService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketMapper ticketMapper;
    /**
     * 分页查询年票信息
     *
     * @param pageNo
     * @return
     */
    @Override
    public PageInfo<Ticket> findTicketByPage(Integer pageNo,String ticketNum) {
        PageHelper.startPage(pageNo,10);
        List<Ticket>  tickets = new ArrayList<>();

        TicketExample ticketExample = new TicketExample();

        if(StringUtils.isNotEmpty(ticketNum)) {
            ticketExample.createCriteria().andTicketNumEqualTo(ticketNum);
        }
          tickets =ticketMapper.selectByExample(ticketExample);

        return new PageInfo<>(tickets);
    }

    /**
     * 统计年票数量，以状态分类
     *
     * @return
     */
    @Override
    public Map<String, Long> findTongJiByState() {

        return ticketMapper.tongjiByState();
    }

    /**
     * 根据ID把票的状态修改成作废
     *
     * @param id
     */
    @Override
    public void invalidById(Integer id) {

        Ticket ticket =ticketMapper.selectByPrimaryKey(id);
        if(ticket == null) {
            throw new ServiceException("参数异常");
        }
        ticket.setTicketState(Ticket.TICKET_STATE_DISABLE);
        ticket.setUpdateTime(new Date());
        ticketMapper.updateByPrimaryKeySelective(ticket);
    }

    /**
     * @param ticketnum
     * @return
     */
    @Override
    public Ticket seleteByTicketNum(String ticketnum) {
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketNumEqualTo(ticketnum);
        List<Ticket> ticketList = ticketMapper.selectByExample(ticketExample);
        if(ticketList.size() == 0 ) {
            throw  new ServiceException("参数错误！");
        }
        return ticketList.get(0);
    }
}
