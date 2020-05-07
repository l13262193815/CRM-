package com.hjcrm.controller.system;

import com.hjcrm.bean.Menu;
import com.hjcrm.bean.Menu_role;
import com.hjcrm.bean.Role;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.service.system.MenuService;
import com.hjcrm.service.system.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    /*角色管理页面*/
    @RequestMapping(value = "/system/roleMang.do", method = RequestMethod.GET)
    public String roleMang(Model model, HttpSession session) {
        if (session.getAttribute("loginName") != null) {
            return JumpView.SYSTEM_ROLEMANG_VIEW;
        }
        return JumpView.SYSTEM_LOGIN_VIEW;//登录页面
    }

    /*根据Deptid查询角色列表*/
    @RequestMapping(value = "/role/queryRoleByDeptid.do", method = RequestMethod.GET)
    @ResponseBody
    public String queryRoleByDeptid(String deptid) {
        if (StringUtils.isNotBlank(deptid)) {
            List<Role> list = roleService.queryRoleByDeptid(deptid);
            String jsonToPage = PageBean.jsonToPage(list, null);
            return jsonToPage;
        }
        return ReturnResult.SYSTEM_NULL_ERROR;//返回一个空字符串
    }
/*查所有*/
    @RequestMapping("/role/queryAllRole.do")
    @ResponseBody
    public String queryAllRole(Integer pageSize, Integer currentPage) {
        System.out.println("currentPage:" + currentPage);
        System.out.println("pageSize:" + pageSize);
        PageBean util = new PageBean();
        util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
        util.setPageSize(pageSize);//查询条数
        List<Role> roles = roleService.queryAllRoleInfo(util);
        util.setCurrentPage(currentPage);
        util.setCountResult(roleService.queryAllRoleInfoCount());//获取总条数
        String userJsonResult = JsonUtil.jsonToPage(roles, util);
        return userJsonResult;
    }

    /*添加、修改*/
    @RequestMapping(" /role/addOrUpdateRole.do")
    @ResponseBody
    public String addOrUpdateRole(Role role) {
        int i = roleService.addOrUpdateRole(role);
        if (i > 0) {
            return ReturnResult.SYSTEM_SUCCESS;
        }
        return ReturnResult.SYSTEM_NULL_ERROR;
    }

    /*删除*/
    @RequestMapping("/role/deleteRole.do")
    @ResponseBody
    public void deleteRole(String ids) {
        int i = roleService.deleteRole(ids);
        if (i > 0) {
            System.out.println("删除成功");
        }
    }

    @Autowired
    private MenuService menuService;

    /*查询所有权限*/
    @RequestMapping("/rolemenu/queryAllMenuAndSelected.do")
    @ResponseBody
    public String queryAllMenuAndSelected(String roleid) throws Exception {
        /*查询所有菜单*/
        List<Menu> list = menuService.queryMenuRoleId();
        /*根据roleid查询当前用户拥有的菜单*/
        List<Menu> listRole = menuService.queryAllMenuAndSelected(roleid);
        /*一级菜单选中状态*/
        if (list != null & list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < listRole.size(); j++) {
                    if (listRole.get(j) != null) {
                        if (listRole.get(j).getMenuid() == list.get(i).getMenuid()) {
                            list.get(i).setSelected(true);
                            break;
                        }
                    }
                }
            }
            /*二级菜单选中状态*/
            /*遍历所有菜单*/
            for (int i = 0; i < list.size(); i++) {
                /*如果二级菜单有内容才去，增强效率*/
                if (list.size() > 0 && list != null) {
                    /*遍历一级菜单中的二级菜单*/
                    List<Menu> children = list.get(i).getChildren();
                    for (int j = 0; j < children.size(); j++) {
                        /*遍历当前用户拥有的菜单*/
                        for (int z = 0; z < listRole.size(); z++) {
                            if (listRole.get(z) != null) {
                                /*如果当前用户选中的菜单id=二级菜单的菜单id*/
                                if (listRole.get(z).getMenuid() == children.get(j).getMenuid()) {
                                    /*给二级菜单设置选中*/
                                    children.get(j).setSelected(true);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        PageBean util = new PageBean();
        String userJsonResult = JsonUtil.jsonToPage(list, null);
        return userJsonResult;
    }

    @RequestMapping("/rolemenu/assignMenu.do")
    @ResponseBody
    public String assignMenu(String roleid, String menuid) {//menuid可以有多个
        //显示删除原用户的角色所对应的菜单关系，再添加
        if (StringUtils.isNotBlank(roleid)) {
            roleService.deleteMenuByroleid(roleid);
            for (String m : menuid.split(",")) {
                if (menuid != "") {
                    Menu_role mr = new Menu_role();
                    mr.setRoleid(Integer.parseInt(roleid));
                    mr.setMenuid(Integer.parseInt(m));
                    roleService.changeMenu(mr);
                }
            }
                return ReturnResult.SYSTEM_SUCCESS;//成功
        }
        return ReturnResult.SYSTEM_NULL_ERROR;//错误
    }
}
