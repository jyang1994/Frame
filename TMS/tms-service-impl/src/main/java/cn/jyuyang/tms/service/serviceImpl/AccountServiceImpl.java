package cn.jyuyang.tms.service.serviceImpl;

import cn.jyuyang.tms.entity.*;
import cn.jyuyang.tms.exception.ServiceException;
import cn.jyuyang.tms.mapper.AccountLoginLogMapper;
import cn.jyuyang.tms.mapper.AccountMapper;
import cn.jyuyang.tms.mapper.AccountRolesMapper;
import cn.jyuyang.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountLoginLogMapper accountLoginLogMapper;
    @Autowired
    private AccountRolesMapper accountRolesMapper;
    /**
     * @param username
     * @param password
     * @param loginIp
     * @return 如果用户名和密码都匹配则返回该对象，如果账号异常、密码不对、账号不存在，返回对应的错误信息
     */
    @Override
    public Account login(String username, String password, String loginIp) throws ServiceException{
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(username);
        List<Account> accountList = accountMapper.selectByExample(accountExample);
        Account account = null;
        if(accountList != null && !accountList.isEmpty()){
            account=accountList.get(0);
            if(account.getPassword().equals(DigestUtils.md5Hex(password))){
                if(account.getDisable()==0){
                    throw new ServiceException("账号被禁用");
                }else if(account.getAccLock()==0){
                    throw new ServiceException("账号被锁定");
                }else{
                    AccountLoginLog accountLoginLog = new AccountLoginLog();
                    accountLoginLog.setAccountId(account.getId());
                    accountLoginLog.setLoginIp(loginIp);
                    accountLoginLog.setLoginTime(new Date());
                    accountLoginLogMapper.insertSelective(accountLoginLog);
                    return account;
                }
            }else{
                throw new ServiceException("账号或者密码错误");
            }
        }else{
            throw new ServiceException("账号不存在");
        }


    }

    /**
     * 增加帐号，同时增加对应的关系，
     *
     * @param account
     * @param rolesId
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveAccountAndRoles(Account account, Integer rolesId) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(account.getUsername());
        List<Account> curracc = accountMapper.selectByExample(accountExample);
        System.out.println(curracc.size()+"sieze");
        AccountRolesKey accountRolesKey = new AccountRolesKey();

        if(curracc.size() == 0){
            account.setAccLock(1);
            account.setDisable(1);
            accountMapper.insertSelective(account);

            accountRolesKey.setAccountId(account.getId());
            accountRolesKey.setRolesId(rolesId);
            accountRolesMapper.insertSelective(accountRolesKey);

        }else{
            throw new ServiceException("帐号已存在");
        }
    }

    /**
     * @return 帐号集合包括对应的角色
     */
    @Override
    public List<Account> findAccountAndRoles() {
        AccountExample accountExample = new AccountExample();

        return accountMapper.selectAccountAndRoles(accountExample);
    }

    /**
     * 根据ID查到对应的account对象
     *
     * @param id
     * @return Account
     */
    @Override
    public Account findAccountById(Integer id) {

        Account account = accountMapper.selectByPrimaryKey(id);
        if(account != null) {
            return account;
        }else{
            throw new ServiceException("不存在对应的账号");
        }

    }

    /**
     * 更新account以及对应的角色
     *
     * @param account
     * @param rolesId
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateAccountAndRoles(Account account, Integer rolesId) {
        accountMapper.updateByPrimaryKeySelective(account);

        AccountRolesKey accountRolesKey = new AccountRolesKey();
        AccountRolesExample accountRolesExample = new AccountRolesExample();
        accountRolesExample.createCriteria().andAccountIdEqualTo(account.getId());

        accountRolesKey.setRolesId(rolesId);
        accountRolesKey.setAccountId(account.getId());
        accountRolesMapper.updateByExample(accountRolesKey,accountRolesExample);

    }


}
