package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.Customer;
import cn.jyuyang.tms.entity.Sales;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SaleService {
    /**
     * 保存消费哲信息和订单信息
     * @param customer
     * @param sales
     */
    void saveCustomerAndSales(Customer customer, Sales sales);

    /**
     * 查到所有的销售记录
     * @return
     * @param p
     * @param username
     * @param mobile
     */
    PageInfo<Sales> findALLSales(Integer p, String username, String mobile);

    /**
     * 支付id对应的订单
     * @param id
     */
    void payById(Integer id);

    /**
     * 根据id删除sale
     * 需要判断id参数是否正确，状态是否为未支付
     * @param id
     */
    void deleteById(Integer id);

    PageInfo<Sales> findALLSalesByMobile(Integer p, String mobile);

    /**
     * 挂失年票
     * @param id
     */
    void loseById(Integer id);
}
