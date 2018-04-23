package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.Ticket;
import cn.jyuyang.tms.entity.TicketExample;
import cn.jyuyang.tms.mapper.TicketMapper;
import cn.jyuyang.tms.service.TicketService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PageInfo<Ticket> findTicketByPage(Integer pageNo) {
        PageHelper.startPage(pageNo,10);

        List<Ticket>  tickets =ticketMapper.selectTicketAndStore();
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
}
