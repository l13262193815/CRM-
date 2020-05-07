package com.hjcrm.controller.system;

import com.hjcrm.bean.Subject;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.service.system.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    /*课程管理页面*/
    @RequestMapping(value = "/system/subjectMang.do", method = RequestMethod.GET)
    public String subjectMang(Model model, HttpSession session) {
        if (session.getAttribute("loginName") != null) {
            return JumpView.SYSTEM_SUBJECTMANG_VIEW;
        }
        return JumpView.SYSTEM_LOGIN_VIEW;//登录页面
    }
/*查所有*/
    @RequestMapping(value = "/subject/querySubject.do", method = RequestMethod.GET)
    @ResponseBody
    public String querySubject(Integer currentPage, Integer pageSize,Integer courseid) {
        if(currentPage==null && pageSize==null){
                List<Subject> subjects=subjectService.querySubjectByCourseid(courseid);
                return JsonUtil.jsonToPage(subjects,null);
        }else {
            System.out.println("currentPage:" + currentPage);
            System.out.println("pageSize:" + pageSize);
            PageBean util = new PageBean();
            util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
            util.setPageSize(pageSize);//查询条数
            List<Subject> roles = subjectService.querySubject(util);
            util.setCurrentPage(currentPage);
            util.setCountResult(subjectService.querySubjectCount());//获取总条数
            String userJsonResult = JsonUtil.jsonToPage(roles, util);
            return userJsonResult;
        }
    }
/*添加、修改*/
    @RequestMapping(value = "/subject/addOrUpdateSubject.do", method = RequestMethod.POST)
    @ResponseBody
    public String addOrUpdateSubject(Subject subject) {
        int i = subjectService.addOrUpdateSubject(subject);
        return ReturnResult.SYSTEM_SUCCESS;
    }
    /*删除*/
    @RequestMapping(value = "/subject/deleteSubject.do", method = RequestMethod.POST)
    @ResponseBody
    public void deleteSubject(String subjectids) {
        int i = subjectService.deleteSubject(subjectids);
    }
}
