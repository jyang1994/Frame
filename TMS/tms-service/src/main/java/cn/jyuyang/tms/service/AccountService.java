package cn.jyuyang.tms.service;

import cn.jyuyang.tms.entity.Account;
import cn.jyuyang.tms.entity.Roles;

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

    /**
     * 根据ID查到对应的account对象
     * @return Account
     * @param id
     */
    Account findAccountById(Integer id);

    /**
     * 更新account以及对应的角色
     * @param account
     * @param rolesId
     */
    void updateAccountAndRoles(Account account, Integer rolesId);

    /**
     * 删除id对应的账号以及与角色关系数据
     */
    void deleteAccountAndRolesKey(Integer accountId);
}