package com.hjcrm.controller.system;

import com.hjcrm.bean.Menu;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    /*菜单管理页面*/
    @RequestMapping(value = "/system/menuMang.do", method = RequestMethod.GET)
    public String menuMang(Model model, HttpSession session) {
        if (session.getAttribute("loginName") != null) {
            return JumpView.SYSTEM_MENUMANG_VIEW;
        }
        return JumpView.SYSTEM_LOGIN_VIEW;//登录页面
    }

    /*查询所有菜单列表*/
    @RequestMapping(value = "/menu/queryAllMenu.do", method = RequestMethod.GET)
    @ResponseBody
    public String queryAllMenu(String roleid) throws Exception {
        List<Menu> menus = menuService.queryAllMenu(roleid);
        return JsonUtil.jsonToPage(menus, null);
    }

    /*添加、修改菜单*/
    @RequestMapping(value = "/menu/addOrUpdateMenu.do", method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdateMenu(Menu menu) throws Exception {
        int i = menuService.addOrUpdateMenu(menu);
        return ReturnResult.SYSTEM_SUCCESS;
    }

    /*删除菜单*/
    @RequestMapping(value = "/menu/delete.do", method = RequestMethod.POST)
    @ResponseBody
    public String delete(String ids) throws Exception {
        StringBuilder s = new StringBuilder();
        Boolean b=false;
        for (String id : ids.split(",")) {
            //*判断是否为一级菜单*//*
            if (menuService.hasSecondaryChild(id)) {
                s.append("当前菜单是一级菜单,存在二级菜单");
                continue;
            }
            //*判断菜单是否被分配*//*
            if (menuService.hasRoles(id)) {
                s.append("此菜单已被分配角色");
                continue;
            }
            //*当前菜单不是一级菜单 且 此菜单未被分配角色*//*
            //*到这说明上面两个if都不满足，执行delete操作*//*
            b = true;
            int i = menuService.delete(id);
            if (i > 0 && b) {
                //成功就刷新页面
                return ReturnResult.SYSTEM_SUCCESS;
            }else{
                return s.toString();
            }
        }
        return ReturnResult.SYSTEM_NULL_ERROR;
    }

}
