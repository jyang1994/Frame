package cn.jyuyang.tms.shiro;

import cn.jyuyang.tms.entity.*;
import cn.jyuyang.tms.entity.Account;
import cn.jyuyang.tms.service.AccountService;
import cn.jyuyang.tms.service.RolesPermissionService;
import cn.jyuyang.tms.service.StoreAccountService;
import cn.jyuyang.tms.service.StoreService;
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
    private StoreAccountService storeAccountService;


    @Autowired
    private StoreService storeService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

       /* Account account = (Account) principalCollection.getPrimaryPrincipal();

        List<Roles> rolesList = rolesPermissionService.findRolesByAccountId(account.getId());
        List<Permission> permissionList = new ArrayList<>();

        for(Roles roles : rolesList) {
            List<Permission> tempList =rolesPermissionService.findPermissionByRolesId(roles.getId());
            permissionList.addAll(tempList);
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
        return simpleAuthorizationInfo;*/
       return null;

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
            StoreAccount account = storeAccountService.findStoreAccountWithStore(userName);

            if (account == null ) {

                throw new UnknownAccountException("找不到该账号: "+account.getManagerMobile());
            }else if(true) {


                logger.info("{} 登录成功: {}",account,usernamePasswordToken.getHost());
               StoreSticket storeSticket = storeService.selectStoreStricketById(account.getStoreSciketId());

                return new SimpleAuthenticationInfo(storeSticket,account.getPassword(),getName());
            }else {
                throw new LockedAccountException("帐号被禁用");
            }

        }

        return null;
    }

}
