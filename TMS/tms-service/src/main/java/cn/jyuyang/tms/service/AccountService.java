package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.Account;

import java.util.List;

public interface AccountService {
    /**
     *
     * @param username
     * @param password
     * @param loginIp
     * @return 如果用户名和密码都匹配则返回该对象，如果账号异常、密码不对、账号不存在，返回对应的错误信息
     */
    Account login(String username, String password, String loginIp);

    /**
     * 增加帐号，同时增加对应的关系，
     * @param account
     * @param rolesId
     * 需要事务处理
     */
    void saveAccountAndRoles(Account account, Integer rolesId);

    /**
     * @return 帐号集合包括对应的角色
     */
    List<Account> findAccountAndRoles();
}
