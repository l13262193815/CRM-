package com.hjcrm.service.system;

import com.hjcrm.constants.util.PageBean;
import com.hjcrm.bean.Menu_role;
import com.hjcrm.bean.Role;
import com.hjcrm.dao.system.RoleDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public List<Role> queryRoleByDeptid(String deptid) {
        List<Role> list = roleDao.queryRoleByDeptid(deptid);
        return list;
    }
    public List<Role> queryAllRoleInfo(PageBean pageBean) {
        return roleDao.queryAllRoleInfo(pageBean);
    }


    public int queryAllRoleInfoCount() {
        return roleDao.queryAllRoleInfoCount();
    }

    public int addOrUpdateRole(Role role) {
        if(role.getRoleid()==0) {//add
            return roleDao.addOrUpdateRole(role);
        }else{
            return roleDao.addOrUpdateRoles(role);//修改
        }
    }

    public int deleteRole(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            List<String> list = new ArrayList<String>();
            for (String id : ids.split(",")) {//String[]
                // for(元素类型 元素：数组名){语句体;}
                list.add(id);
            }
            return roleDao.deleteRole(list);
        }
        return -1;
    }


    public void deleteMenuByroleid(String roleid) {
        if(StringUtils.isNotBlank(roleid)) {
            roleDao.deleteMenuByroleid(roleid);
        }
    }

    public void changeMenu(Menu_role mr) {
        if(mr!=null) {
            roleDao.changeMenu(mr);
        }
    }
}
