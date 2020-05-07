package com.hjcrm.controller.system;

import com.hjcrm.bean.Course;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.service.system.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
    /*课程管理*/
public class CourseController {
    @Autowired
    private CourseService courseService;
/*跳转页面*/
    @RequestMapping(value = "/system/courseMang.do", method = RequestMethod.GET)
    public String courseMang(Model model, HttpSession session) {
        if (session.getAttribute("loginName") != null) {
            return JumpView.SYSTEM_COURSEMANG_VIEW;
        }
        return JumpView.SYSTEM_LOGIN_VIEW;//登录页面
    }
/*查所有*/
    @RequestMapping(value = "/course/queryCourse.do", method = RequestMethod.GET)
    @ResponseBody
    public String queryCourse(Integer currentPage, Integer pageSize) {
        if (currentPage == null && pageSize == null) {
            List<Course> course = courseService.queryCourse();//全查询，不分页
            String userJsonResult = JsonUtil.jsonToPage(course,null);
            return userJsonResult;
        } else {//查询，分页
            System.out.println("currentPage:" + currentPage);
            System.out.println("pageSize:" + pageSize);
            PageBean util = new PageBean();
            util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
            util.setPageSize(pageSize);//查询条数
            List<Course> roles = courseService.queryCourses(util);
            util.setCurrentPage(currentPage);
            util.setCountResult(courseService.queryCourseCount());//获取总条数
            String userJsonResult = JsonUtil.jsonToPage(roles, util);
            return userJsonResult;
        }
    }
/*添加修改*/
    @RequestMapping(value = "/course/addCourse.do", method = RequestMethod.POST)
    @ResponseBody
    public String addCourse(Course course) {
        int i = courseService.addCourse(course);
        return ReturnResult.SYSTEM_SUCCESS;
    }
/*删除*/
    @RequestMapping(value = "/course/deleteCourse.do", method = RequestMethod.POST)
    @ResponseBody
    public void deleteCourse(String courseids) {
        int i = courseService.deleteCourse(courseids);
    }
}
