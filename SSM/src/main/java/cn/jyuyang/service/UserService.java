package cn.jyuyang.service;

import cn.jyuyang.entity.User;


public interface UserService {
    /**
     *
     * @param id
     * @return
     */
    User findById(Integer id);
}
