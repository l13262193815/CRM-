package com.hjcrm.dao.system;

import com.hjcrm.bean.Role;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.bean.Menu_role;

import java.util.List;

public interface RoleDao {
    /*用户管理页面的添加方法中的一个下拉列表的值*/
    public List<Role> queryRoleByDeptid(String deptid);
    /*分页*/
    List<Role> queryAllRoleInfo(PageBean pageBean);
    /*查总数*/
    int queryAllRoleInfoCount();
    /*添加*/
    int addOrUpdateRole(Role role);
    /*删除*/
    int deleteRole(List<String> list);
    /*修改*/
    int addOrUpdateRoles(Role role);
/*删除roleid对应的菜单*/
    void deleteMenuByroleid(String roleid);
/*添加roleid对应的菜单*/
    void changeMenu(Menu_role mr);
}
