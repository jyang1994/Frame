package cn.jyuyang.service.impl;

import cn.jyuyang.entity.User;
import cn.jyuyang.mapper.UserMapper;
import cn.jyuyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * @param id
     * @return
     */
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
