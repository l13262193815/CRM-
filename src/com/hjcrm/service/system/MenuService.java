package com.hjcrm.service.system;

import com.hjcrm.bean.Menu;
import com.hjcrm.dao.system.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("menuService")
public class MenuService {
    @Autowired
    private MenuDao menuDao;

    /*添加/修改*/
    public int addOrUpdateMenu(Menu menu) {
        if (menu.getMenuid() == 0) {
            System.out.println("添加");
            return menuDao.addOrUpdateMenu(menu);//添加
        } else {
            System.out.println("修改");
            return menuDao.addOrUpdateMenus(menu);//修改
        }
    }

    /*菜单页面查询所有菜单列表*/
    public List<Menu> queryAllMenu(String roleid) throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("roleid", roleid);
        hashMap.put("menuparaid", "-1");
        List<Menu> first = menuDao.queryAllMenu(hashMap);//一级菜单
        for (Menu m : first) {
            //重新给参数赋值
            hashMap.put("roleid", roleid);
            hashMap.put("menuparaid", m.getMenuid() + "");//将menuid做为menuidparaid的值
            List<Menu> menus = menuDao.queryAllMenu(hashMap);//获取二级菜单
            m.setChildren(menus);//将二级菜单放到一级菜单的一个属性中
        }
        return first;
    }

    /*Role页面查询所有菜单列表*/
    public List<Menu> queryMenuRoleId() throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("menuparaid", "-1");
        List<Menu> first = menuDao.queryMenuByRoleId(hashMap);//一级菜单
        for (Menu m : first) {
            //重新给参数赋值
            hashMap.put("menuparaid", m.getMenuid() + "");//将menuid做为menuidparaid的值
            List<Menu> menus = menuDao.queryMenuByRoleId(hashMap);//获取二级菜单
            m.setChildren(menus);//将二级菜单放到一级菜单的一个属性中
        }
        return first;
    }

    public List<Menu> queryAllMenuAndSelected(String roleid) throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("roleid", roleid);
        /*根据roleid查询所有角色拥有的所有菜单，不论一级还是二级*/
        List<Menu> menus = menuDao.queryMenuByRoleId(hashMap);
        return menus;
    }

    public int delete(String id) {
        int i = menuDao.delete(Integer.parseInt(id));
        if (i > 0) {
            return i;
        } else {
            return -1;
        }
    }

    /*判断是否是一级菜单*/
    public boolean hasSecondaryChild(String id) {
        /*>0说明他是一个有二级菜单的一级菜单*/
        return menuDao.hasSecondaryChild(Integer.parseInt(id)).size() > 0 ? true : false;
    }

    public boolean hasRoles(String id) {
        /*>0说明已经被分配过角色*/
        return menuDao.hasRoles(Integer.parseInt(id)).size() > 0 ? true : false;
    }

}
