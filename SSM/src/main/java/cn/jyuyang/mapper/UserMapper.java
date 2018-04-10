package cn.jyuyang.mapper;

import cn.jyuyang.entity.User;

import java.util.List;

public interface UserMapper {

    User findById(Integer id);

    List<User> findAll();
}
