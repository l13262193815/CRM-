package com.hjcrm.controller.resource;

import com.hjcrm.bean.Resource;
import com.hjcrm.bean.Student;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.service.resource.ResourceService;
import com.hjcrm.service.resource.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ResourceService resourceService;
    /*显示学员管理页面*/
    @RequestMapping("/sales/studentMang.do")
    public String studentMang() {
        return JumpView.SALES_STUDENT_VIEW;
    }
    /*查所有*/
    @RequestMapping("/student/queryStudents.do")
    @ResponseBody
    public String queryStudents(String userid,String deptid,String roleid,Integer currentPage,Integer pageSize) {
        PageBean util = new PageBean();
        util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
        util.setPageSize(pageSize);//查询条数
        List<Student> list = studentService.queryStudents(userid,deptid,roleid,currentPage,pageSize);
        util.setCurrentPage(currentPage);
        util.setPageSize(pageSize);//查询条数
        return JsonUtil.jsonToPage(list,null);
    }
    /*退回*/
    @RequestMapping("/student/returnStudent.do")
    @ResponseBody
    public String returnStudent(String resourceIds) {
       int i=studentService.returnStudent(resourceIds);
        return ReturnResult.SYSTEM_SUCCESS;
    }

}
