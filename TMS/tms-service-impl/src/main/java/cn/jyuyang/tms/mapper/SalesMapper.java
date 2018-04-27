package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.Sales;
import cn.jyuyang.tms.entity.SalesExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SalesMapper {

    List<Sales> findAllSalesAndCustomer(Map<String,Object> maps);

    long countByExample(SalesExample example);

    int deleteByExample(SalesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sales record);

    int insertSelective(Sales record);

    List<Sales> selectByExample(SalesExample example);

    Sales selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByExample(@Param("record") Sales record, @Param("example") SalesExample example);

    int updateByPrimaryKeySelective(Sales record);

    int updateByPrimaryKey(Sales record);

    List<Sales> findAllSalesAndCustomerByMobile(String mobile);
}