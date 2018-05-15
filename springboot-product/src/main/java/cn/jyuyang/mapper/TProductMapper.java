package cn.jyuyang.mapper;

import cn.jyuyang.entity.TProduct;
import cn.jyuyang.entity.TProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductMapper {
    long countByExample(TProductExample example);

    int deleteByExample(TProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    List<TProduct> selectByExample(TProductExample example);

    TProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByExample(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);
}