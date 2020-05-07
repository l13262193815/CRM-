package com.hjcrm.service.system;

import com.hjcrm.bean.User;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.bean.Menu;
import com.hjcrm.dao.system.MenuDao;
import com.hjcrm.dao.system.UserDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MenuDao menuDao;

    public User selectUserByEmail(String email) throws Exception {
        return userDao.selectUserByEmail(email);
    }

    public User login(User user) throws Exception {
        User user1 = userDao.login(user);
        System.out.println(user1);
        return user1;
    }

    /*主页面*/
    /*查询当前角色匹配的菜单列表*/
    public List<Menu> queryMenuRoleId(String roleid) throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("roleid", roleid);
        hashMap.put("menuparaid", "-1");
        List<Menu> first = userDao.queryMenuByRoleId(hashMap);//一级菜单
        for (Menu m : first) {
            //重新给两个参数赋值
            hashMap.put("roleid", roleid);
            hashMap.put("menuparaid", m.getMenuid() + "");//将menuid做为menuidparaid的值
            List<Menu> menus = userDao.queryMenuByRoleId(hashMap);//获取二级菜单
            m.setChildren(menus);//将二级菜单放到一级菜单的一个属性中
        }
        return first;
    }

    public List<User> queryAllUserInfo(PageBean pageBean) {
        return userDao.queryAllUserInfo(pageBean);
    }
    ;

    public int saveOrUpdate(User user) {
        if(user!=null) {
            if(user.getUserid()==0){//add，没有userid的字段
                return userDao.saveOrUpdate(user);//添加
            }else{
                return userDao.saveOrUpdates(user);//修改
            }
        }
        return -1;
    }

    public int deleteUser(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            List<String> list = new ArrayList<String>();
            for (String id : ids.split(",")) {//String[]
                // for(元素类型 元素：数组名){语句体;}
                list.add(id);
            }
            return userDao.deleteUser(list);
        }
        return -1;
    }

    public int editPassword(HashMap<String, String> hashMap) {
        return userDao.editPassword(hashMap);
    }

    public int queryAllUserInfoCount() {
        return userDao.queryAllUserInfoCount();
    }
}

