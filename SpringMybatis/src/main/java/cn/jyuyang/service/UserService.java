package cn.jyuyang.service;

import cn.jyuyang.entity.User;
import cn.jyuyang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findById(Integer id){
        return userMapper.findById(id);
    }
}

