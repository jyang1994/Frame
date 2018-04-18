package cn.jyuyang.tms.shiro;

import cn.jyuyang.tms.entity.Permission;
import cn.jyuyang.tms.service.RolesPermissionService;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerFilterChainDefinition implements FactoryBean<Ini.Section>{
    @Autowired
    private RolesPermissionService rolesPermissionService;

    private String filterChainDefinitions;

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    @Override
    public Ini.Section getObject() throws Exception {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);

        List<Permission> permissionList = rolesPermissionService.findAllPermission();

        Ini.Section section = ini.get(Ini.DEFAULT_SECTION_NAME);

        for(Permission permission : permissionList){
            section.put(permission.getUrl(),"perms["+permission.getPermissionCode()+"]");
        }
        section.put("/**","user");

        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return Ini.Section.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
