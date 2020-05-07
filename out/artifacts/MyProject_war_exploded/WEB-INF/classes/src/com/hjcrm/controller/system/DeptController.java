package com.hjcrm.controller.system;
import com.hjcrm.bean.Dept;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.service.system.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    /*请求部门管理页面*/
    @RequestMapping(value = "/system/deptMang.do", method = RequestMethod.GET)
    public String deptMang(Model model, HttpSession session) {
        if (session.getAttribute("loginName") != null) {
            return JumpView.SYSTEM_DEPTMANG_VIEW;
        }
        return JumpView.SYSTEM_LOGIN_VIEW;//登录页面
    }

/*    查询所有部门列表*/
    @RequestMapping(value = "/dept/queryDept.do", method = RequestMethod.GET)
    @ResponseBody
    public String queryDept(Integer currentPage,Integer pageSize)  {
        if(currentPage==null && pageSize==null){
            List<Dept> roles = deptService.queryAllDeptInfos();
            String userJsonResult = JsonUtil.jsonToPage(roles, null);
            return userJsonResult;
        }else{
            System.out.println("currentPage:" + currentPage);
            System.out.println("pageSize:" + pageSize);
            PageBean util = new PageBean();
            util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
            util.setPageSize(pageSize);//查询条数
            List<Dept> roles = deptService.queryAllDeptInfo(util);
            util.setCurrentPage(currentPage);
            util.setCountResult(deptService.queryAllDeptInfoCount());//获取总条数
            String userJsonResult = JsonUtil.jsonToPage(roles, util);
            return userJsonResult;
        }
    }


    /*添加*/
    @RequestMapping(value = "/dept/saveOrUpdate.do", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrUpdate(Dept dept) {
        int i=deptService.saveOrUpdate(dept);
        return ReturnResult.SYSTEM_SUCCESS;
    }
    /*删除*/
    @RequestMapping(value = "/dept/delete.do", method = RequestMethod.POST)
    @ResponseBody
    public void delete(String ids) throws Exception {
        int i = deptService.delete(ids);
    }

}
