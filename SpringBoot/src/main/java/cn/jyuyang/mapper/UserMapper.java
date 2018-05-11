package cn.jyuyang.mapper;

import cn.jyuyang.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findById(Integer id);
}
