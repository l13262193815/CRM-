package com.hjcrm.controller.system;
import com.hjcrm.bean.Menu;
import com.hjcrm.bean.User;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.service.system.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/loginjsp.do", method = RequestMethod.GET)
    public String loginView(Model model) {
        return JumpView.SYSTEM_LOGIN_VIEW;
    }//登录页面
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(Model model, String email, String password, String sign, HttpServletRequest request) throws Exception {
        /*判断当前参数是否为空*/
        if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {
            User email1 = userService.selectUserByEmail(email + sign);//123@qq.com
            if (email1 == null) {
                model.addAttribute("msg", ReturnResult.SYSTEM_USER_ERROR);//用户名不存在1
                return JumpView.SYSTEM_LOGIN_VIEW;
            }
            User password1 = userService.login(new User(email + sign,password));
            if (password1 == null) {
                model.addAttribute("msg",ReturnResult.SYSTEM_PASSWORD_ERROR);//密码错误2
                return JumpView.SYSTEM_LOGIN_VIEW;
            }
            if (password != null && email1 != null) {
                System.out.println("登陆成功");
                //当前登录用户
                request.getSession().setAttribute("loginName",password1.getUsername());//登录的用户名
                request.getSession().setAttribute("roleid",password1.getRoleid());//登录的用户的roleid
                request.getSession().setAttribute("login_user",password1);//登录的用户
                return "forward:main.do";//返回主页面
            }
        }
        return ReturnResult.SYSTEM_NULL_ERROR;//未知错误，请联系管理员
    }
    /*跳转主页面*/
    @RequestMapping("/main.do")
    public String main(HttpSession session,HttpServletRequest request){
        try {
            Object roleid = session.getAttribute("roleid");//角色id
            List<Menu> menus = userService.queryMenuRoleId(roleid+"");//根据角色id获取对应的菜单信息
            request.setAttribute("menus",menus);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JumpView.SYSTEM_INDEX_VIEW;
    }
    /*退出*/
    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return JumpView.SYSTEM_LOGIN_VIEW;
    }

}
