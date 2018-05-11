package cn.jyuyang.service;

import cn.jyuyang.entity.User;

public interface UserService {
    /**
     * 根据ID查找对应的user
     * @param id
     * @return
     */
    User findById(Integer id);
}
