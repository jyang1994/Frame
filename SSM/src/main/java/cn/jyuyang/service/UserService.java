package cn.jyuyang.service;

import cn.jyuyang.entity.User;

import java.util.List;


public interface UserService {
    /**
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 查询所有用户信息
     * @return 用户数组
     */
    List<User> findAll();
}
