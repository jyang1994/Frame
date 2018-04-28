package cn.jyuyang.tms.mapper;

import cn.jyuyang.tms.entity.CustomerPhoto;
import cn.jyuyang.tms.entity.CustomerPhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerPhotoMapper {
    long countByExample(CustomerPhotoExample example);

    int deleteByExample(CustomerPhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerPhoto record);

    int insertSelective(CustomerPhoto record);

    List<CustomerPhoto> selectByExample(CustomerPhotoExample example);

    CustomerPhoto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerPhoto record, @Param("example") CustomerPhotoExample example);

    int updateByExample(@Param("record") CustomerPhoto record, @Param("example") CustomerPhotoExample example);

    int updateByPrimaryKeySelective(CustomerPhoto record);

    int updateByPrimaryKey(CustomerPhoto record);
}