package com.hjcrm.dao.system;
import java.util.HashMap;
import java.util.List;

import com.hjcrm.bean.User;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.bean.Menu;

public interface UserDao {
	User selectUserByEmail(String email) throws Exception;//查询email是否存在
	User login(User user) throws Exception;//登录
	List<User> queryAllUserInfo(PageBean pageBean);//查所有用户
    int queryAllUserInfoCount();//查询总条数
    int saveOrUpdate(User user);//添加
    int saveOrUpdates(User user);//修改
	int deleteUser(List list);//删除
	int editPassword(HashMap<String, String> hashMap);//修改密码

    List<Menu> queryMenuByRoleId(HashMap<String, String> hashMap);

	User queryUserInfoById(int userid);
}
