package cn.jyuyang.service.impl;

import cn.jyuyang.entity.User;
import cn.jyuyang.mapper.UserMapper;
import cn.jyuyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 查询所有用户信息
     *
     * @return 用户数组
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
