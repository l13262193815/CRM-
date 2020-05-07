package com.hjcrm.controller.system;

import com.hjcrm.bean.User;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.constants.util.MD5Utils;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*用户管理页面*/
    @RequestMapping(value = "/system/userMang.do", method = RequestMethod.GET)
    public String userMang(HttpSession session) {
        if (session.getAttribute("loginName") != null) {//用户已登录
            return JumpView.SYSTEM_USERMANG_VIEW;//用户管理页面
        }
        return JumpView.SYSTEM_LOGIN_VIEW;//登录页面
    }
/*用户信息显示*/
    @RequestMapping("/system/userlist.do")
    @ResponseBody
    public String userList(Integer pageSize, Integer currentPage) {
        System.out.println("currentPage:" + currentPage);
        System.out.println("pageSize:" + pageSize);
        PageBean util = new PageBean();
        util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
        util.setPageSize(pageSize);//查询条数
        List<User> users = userService.queryAllUserInfo(util);
        util.setCurrentPage(currentPage);
        util.setCountResult(userService.queryAllUserInfoCount());//获取总条数
        String userJsonResult = JsonUtil.jsonToPage(users, util);
        return userJsonResult;
    }

    /*添加、修改用户*/
    @RequestMapping("/system/saveOrUpdate.do")
    @ResponseBody
    public String saveOrUpdate(User user) throws Exception {
        if (user != null) {//user有信息
            User user1 = userService.selectUserByEmail(user.getEmail());
            if(user.getUserid()==0){//add操作
                if (user1 != null) {
                    return ReturnResult.SYSTEM_EMAIL_REPE;//email已存在，不可以再添加  5
                }
            }
            int i = userService.saveOrUpdate(user);
            if (i > 0) {
                return ReturnResult.SYSTEM_SUCCESS;//重新加载用户管理页面
            }
        }
        return ReturnResult.SYSTEM_NULL_ERROR;//空字符串
    }

    /*删除用户*/
    @RequestMapping("/system/deleteUser.do")
    @ResponseBody
    public void deleteUser(String ids) throws Exception {
        int i = userService.deleteUser(ids);
    }

    /*修改密码*/
    @RequestMapping(value = "system/editPassword.do", method = RequestMethod.POST)
    @ResponseBody
    public String editPassword(String userid, String newPassword, String oldPassword, HttpServletRequest request) {
        System.out.println("userid:" + userid + "   newPassword:" + newPassword + "   oldPassword:" + oldPassword);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("userid", userid);
        hashMap.put("newPassword", newPassword);
        hashMap.put("oldPassword", oldPassword);
        User user = (User) request.getSession().getAttribute("login_user");
        if (!user.getPassword().equals( MD5Utils.MD5Encode(oldPassword,"utf-8"))) {
            return ReturnResult.SYSTEM_EMAIL_OLD;//旧密码不匹配
        }
        int i = userService.editPassword(hashMap);
        return ReturnResult.SYSTEM_SUCCESS;
    }

}
