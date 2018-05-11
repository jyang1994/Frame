package cn.jyuyang.service.serviceimpl;

import cn.jyuyang.cache.RedisCacheUtil;
import cn.jyuyang.entity.User;
import cn.jyuyang.mapper.UserMapper;
import cn.jyuyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Autowired
    private UserMapper userMapper;
    /**
     * 根据ID查找对应的user
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        String key ="user:"+id;
        User user = (User) redisCacheUtil.getValue(key,User.class);
        if(user==null){
            user=userMapper.findById(id);
            redisCacheUtil.setValue(key,user);
        }
        return user;

    }
}
