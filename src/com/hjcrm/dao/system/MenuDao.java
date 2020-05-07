package com.hjcrm.dao.system;
import com.hjcrm.bean.Menu_role;
import com.hjcrm.bean.Menu;

import java.util.HashMap;
import java.util.List;

public interface MenuDao {
    /*角色页面显示菜单*/
	public List<Menu> queryMenuByRoleId(HashMap<String, String> hashMap) throws Exception;
	/*菜单页面显示菜单*/
	public List<Menu> queryAllMenu(HashMap<String, String> hashMap) throws Exception;

    int addOrUpdateMenu(Menu menu);//添加
    int addOrUpdateMenus(Menu menu);//修改

    int delete(int id);

    List<Menu> hasSecondaryChild(int id);

    List<Menu_role> hasRoles(int id);
}
