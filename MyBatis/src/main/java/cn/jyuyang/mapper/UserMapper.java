package cn.jyuyang.mapper;

import cn.jyuyang.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int save(User user);
    List<User> findAll();
    List<User> page(int start, int size);
    List<User> page2(Map<String, Integer> map);
}
