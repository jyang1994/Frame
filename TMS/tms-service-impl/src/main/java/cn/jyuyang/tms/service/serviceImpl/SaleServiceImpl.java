package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.Customer;
import cn.jyuyang.tms.entity.Sales;
import cn.jyuyang.tms.entity.Ticket;
import cn.jyuyang.tms.entity.TicketExample;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.mapper.CustomerMapper;
import cn.jyuyang.tms.mapper.SalesMapper;
import cn.jyuyang.tms.mapper.TicketMapper;
import cn.jyuyang.tms.service.SaleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private SalesMapper salesMapper;
    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 保存消费哲信息和订单信息
     *
     * @param customer
     * @param sales
     */
    @Override
    public void saveCustomerAndSales(Customer customer, Sales sales) {

        String res = sales.getSaleTicketNum();
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketNumEqualTo(res);

        if( ticketMapper.selectByExample(ticketExample).size()==0){
            throw new ServiceException("票号错误！请核对后重试！");
        }

        customer.setCreateTime(new Date());
        customerMapper.insertSelective(customer);

        sales.setCustomerId(customer.getId());
        sales.setCreateTime(new Date());
        sales.setSaleState("未支付");
        salesMapper.insertSelective(sales);

    }

    /**
     * 查到所有的销售记录
     *
     * @return
     * @param p
     * @param username
     * @param mobile
     */
    @Override
    public PageInfo<Sales> findALLSales(Integer p, String username, String mobile) {

        Map<String,Object> maps = new HashMap<>();
        maps.put("username",username);
        maps.put("mobile",mobile);

        List<Sales> salesList = salesMapper.findAllSalesAndCustomer(maps);
        System.out.println(salesList.size()+"--------------------------------");
        PageHelper.startPage(p,10);
        return new PageInfo<>(salesList);
    }

    /**
     * 支付id对应的订单
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void payById(Integer id) {

        Sales sales = salesMapper.selectByPrimaryKey(id);
        if(sales == null) {
            throw  new ServiceException("参数异常");
        }
        if("已支付".equals(sales.getSaleState())) {
            throw new ServiceException("订单已支付，请勿重复支付");
        }
        sales.setSaleState("已支付");
        salesMapper.updateByPrimaryKeySelective(sales);
        TicketExample ticketExample = new TicketExample();
         ticketExample.createCriteria().andTicketNumEqualTo(sales.getSaleTicketNum());
        List<Ticket> ticketList = ticketMapper.selectByExample(ticketExample);
        if(ticketList.size()==0){
            throw new ServiceException("参数异常");
        }

        Ticket ticket = ticketMapper.selectByExample(ticketExample).get(0);
        ticket.setUpdateTime(new Date());
        ticket.setCreateTime(new Date());
        ticket.setTicketState("已销售");
        ticket.setCustomerId(sales.getCustomerId());
        ticketMapper.updateByPrimaryKeySelective(ticket);

    }

    /**
     * 根据id删除sale
     * 需要判断id参数是否正确，状态是否为未支付
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        Sales sales = salesMapper.selectByPrimaryKey(id);
        if(sales == null) {
            throw  new ServiceException("参数异常");
        }
        if("已支付".equals(sales.getSaleState()) ){
            throw new ServiceException("订单已支付，无法删除");
        }
        salesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Sales> findALLSalesByMobile(Integer p, String mobile) {



        List<Sales> salesList = salesMapper.findAllSalesAndCustomerByMobile(mobile);
        //System.out.println(salesList.size()+"--------------------------------");
        PageHelper.startPage(p,10);
        return new PageInfo<>(salesList);

    }

    /**
     * 挂失年票
     *
     * @param id
     */
    @Override
    public void loseById(Integer id) {
        Ticket ticket = ticketMapper.selectByPrimaryKey(id);
        if(ticket==null) {
            throw new ServiceException("参数异常！");
        }
        if(!"已销售".equals(ticket.getTicketState())){
            throw new ServiceException("年票未使用，无法挂失");
        }

        ticket.setTicketState("挂失");
        ticket.setUpdateTime(new Date());

        ticketMapper.updateByPrimaryKeySelective(ticket);
    }
}
