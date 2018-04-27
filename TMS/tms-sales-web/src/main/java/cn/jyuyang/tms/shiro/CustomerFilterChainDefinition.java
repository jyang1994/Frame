package cn.jyuyang.tms.shiro;

import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.service.RolesPermissionService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

public class CustomerFilterChainDefinition{

    private Logger logger = LoggerFactory.getLogger(CustomerFilterChainDefinition.class);
    @Autowired
    private RolesPermissionService rolesPermissionService;

    private String filterChainDefinitions;

    private AbstractShiroFilter shiroFilter;

    public void setShiroFilter(AbstractShiroFilter shiroFilter) {
        this.shiroFilter = shiroFilter;
    }

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    /**
     * spring容器启动时调用
     */
    @PostConstruct
    public void initPermission(){
        logger.info("------初始化URL权限-----------");
        //清除原有的URL权限
        getFiterChainManager().getFilterChains().clear();
        //加载现有的URL权限
        load();
        logger.info("------初始化URL权限结束-----------");
    }

    public void update(){
        logger.info("------刷新URL权限-----------");
        //清除原有的URL权限
        getFiterChainManager().getFilterChains().clear();
        //加载现有的URL权限
        load();
        logger.info("------刷新URL权限结束-----------");
    }
    /**
     * 动态加载权限控制
     */
    public void load() {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);

        List<Permission> permissionList = rolesPermissionService.findAllPermission();

        Ini.Section section = ini.get(Ini.DEFAULT_SECTION_NAME);

        for(Permission permission : permissionList){
            section.put(permission.getUrl(),"perms["+permission.getPermissionCode()+"]");
        }
        section.put("/**","user");
        DefaultFilterChainManager defaultFilterChainManager = getFiterChainManager();

        for(Map.Entry<String,String> entry : section.entrySet()){
            defaultFilterChainManager.createChain(entry.getKey(),entry.getValue());
        }
    }
    private DefaultFilterChainManager getFiterChainManager(){
        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager defaultFilterChainManager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
        return defaultFilterChainManager;
    }
}
