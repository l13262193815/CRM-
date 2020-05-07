package com.hjcrm.controller.resource;

import com.hjcrm.bean.Course;
import com.hjcrm.bean.User;
import com.hjcrm.bean.Visitrecord;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.*;
import com.hjcrm.bean.Resource;
import com.hjcrm.constants.JumpView;
import com.hjcrm.dao.resource.SalesResourceDao;
import com.hjcrm.service.resource.ResourceService;
import com.hjcrm.service.resource.SalesResourceService;
import com.hjcrm.service.system.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/*运营部*/
@Controller
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private CourseService courseService;

    /*跳转资源管理页面*/
    @RequestMapping(value = "/resource/resourcesMang.do", method = RequestMethod.GET)
    public String resourcesMang(HttpSession session) {
        if (session.getAttribute("loginName") != null) {
            return JumpView.OPPERATE_RESOURESMANG_VIEW;
        }
        return JumpView.SYSTEM_LOGIN_VIEW;//登录页面
    }

    /*运营部-学员管理界面*/
    @RequestMapping(value = "/student/studentMang.do", method = RequestMethod.GET)
    public String index(Model model) {
        return JumpView.STUDENT_YUNYING;
    }

    /*查创建者*/
    @RequestMapping("/resource/queryAllCreatePerson.do")
    @ResponseBody
    public String queryAllCreatePerson() {
        List<User> list = resourceService.queryAllCreatePerson();
        return JsonUtil.jsonToPage(list, null);
    }

    /*获取销售*/
    @RequestMapping("/resource/queryAllXiaoShou.do")
    @ResponseBody
    public String queryAllXiaoShou() {
        List<User> list = resourceService.queryAllXiaoShou();
        return JsonUtil.jsonToPage(list, null);
    }

    /*查所有资源*/
    @RequestMapping("/resource/queryResource.do")
    @ResponseBody
    public String queryResource(String userid, String roleid, String deptid, Integer currentPage, Integer pageSize) {
        PageBean util = new PageBean();
        util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
        util.setPageSize(pageSize);//查询条数
        List<Resource> list = resourceService.queryResource(userid, roleid, deptid, util.getCurrentPage(), util.getPageSize());
        for (int i = 0; i < list.size(); i++) {
            /*查询课程操作*/
            Course course = courseService.queryCourseById(list.get(i).getCourseid());
            if (course != null) {
                list.get(i).setCourseName(course.getCourseName());
            }
            /*查询回访记录操作*/
            //List<Visitrecord> visitrecords = salesResourceService.queryVisitrecordsByresourceId(list.get(i).getResourceId());
            //list.get(i).setVisitRecord(visitrecords);
        }
        util.setCurrentPage(currentPage);
        int i = resourceService.queryResourceCount(userid, deptid, roleid);//查总数
        util.setCountResult(i);
        return JsonUtil.jsonToPage(list, util);
    }

    /*查资源条数总数*/
    @RequestMapping("/resource/queryResourceCount.do")
    @ResponseBody
    public String queryResourceCount(String userid, String deptid, String roleid) {
        int i = resourceService.queryResourceCount(userid, deptid, roleid);
        return JsonUtil.jsonToPage(i, null);
    }

    /*新建*/
    @RequestMapping(value = "/resource/addResource.do", method = RequestMethod.POST)
    @ResponseBody
    public String addResource(Resource resource, Visitrecord visitrecord) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String name = (String) request.getSession().getAttribute("loginName");
        resource.setCreaterName(name);
        int i = resourceService.addResource(resource, visitrecord);
        return ReturnResult.SYSTEM_SUCCESS;
    }

    /*删除*/
    @RequestMapping("/resource/deleteResources.do")
    @ResponseBody
    public String deleteResources(String resourceId) {
        int i = resourceService.deleteResources(resourceId);
        if (i > 0) {
            return ReturnResult.SYSTEM_SUCCESS;
        } else {
            return ReturnResult.SYSTEM_NULL_ERROR;
        }
    }

    /*资源的销售和转移*/
    @RequestMapping("/resource/assigntoResource.do")
    @ResponseBody
    public String assigntoResource(String resourceIds, String belongid, String states) {
        int i = resourceService.assigntoResource(resourceIds, belongid, states);
        if (i > 0) {
            return ReturnResult.SYSTEM_SUCCESS;
        } else {
            return ReturnResult.SYSTEM_NULL_ERROR;
        }
    }

    /*解决  后台返回数据不同*/
    @RequestMapping("/resource/queryResourceBycSeen.do")
    @ResponseBody
    public String queryResourceBySceen(String userid, String deptid, String roleid, Integer currentPage, Integer pageSize) {
        PageBean util = new PageBean();
        util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
        util.setPageSize(pageSize);//查询条数
        List<Resource> list = resourceService.queryResource(userid, roleid, deptid, util.getCurrentPage(), util.getPageSize());
        util.setCurrentPage(currentPage);
        int i = resourceService.queryResourceCount(userid, deptid, roleid);//查总数
        util.setCountResult(i);
        return JsonUtil.jsonToPage(list, util);
    }


}
