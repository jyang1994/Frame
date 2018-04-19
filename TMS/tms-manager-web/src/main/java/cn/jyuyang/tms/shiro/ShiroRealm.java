package cn.jyuyang.tms.shiro;

import cn.jyuyang.tms.entity.Account;
import cn.jyuyang.tms.entity.AccountLoginLog;
import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.entity.Roles;
import cn.jyuyang.tms.service.AccountService;
import cn.jyuyang.tms.service.RolesPermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ShiroRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    @Autowired
    private AccountService accountService;



    @Autowired
    private RolesPermissionService rolesPermissionService;

    /**
     * 判断角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Account account = (Account) principalCollection.getPrimaryPrincipal();

        List<Roles> rolesList = rolesPermissionService.findRolesByAccountId(account.getId());
        List<Permission> permissionList = new ArrayList<>();

        for(Roles roles : rolesList) {
            List<Permission> tempList =rolesPermissionService.findPermissionByRolesId(roles.getId());
            permissionList.addAll(tempList);
        }
        for(Permission permission : permissionList) {
            System.out.println(permission.getPermissionCode()+"----------------------------------------");
        }

        Set<String> rolesCodeSet= new HashSet<>();
        for(Roles roles : rolesList) {
            rolesCodeSet.add(roles.getRoleCode());
        }


        Set<String> permissonCodeSet = new HashSet<>();
        for(Permission permission : permissionList){
            permissonCodeSet.add(permission.getPermissionCode());
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(rolesCodeSet);
        simpleAuthorizationInfo.setStringPermissions(permissonCodeSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 判断登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userName = usernamePasswordToken.getUsername();

        if(userName != null) {
            Account account = accountService.findAccountByUserName(userName);
            if (account == null ) {
                throw new UnknownAccountException("找不到该账号: "+userName);
            }else if(account.getAccLock() == 1 && account.getDisable()==1) {
                logger.info("{} 登录成功: {}",account,usernamePasswordToken.getHost());
                //保存登陆日志
                AccountLoginLog accountLoginLog = new AccountLoginLog();
                accountLoginLog.setLoginTime(new Date());
                accountLoginLog.setAccountId(account.getId());
                accountLoginLog.setLoginIp(usernamePasswordToken.getHost());
                accountService.saveAccountLoginLog(accountLoginLog);
                return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
            }else {
                throw new LockedAccountException("帐号被禁用或者锁定");
            }

        }

        return null;
    }
}
