package com.hjcrm.controller.resource;

import com.hjcrm.bean.*;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.service.resource.ResourceService;
import com.hjcrm.service.resource.SalesResourceService;
import com.hjcrm.service.resource.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
/*销售部*/
@Controller
public class SalesResourceController {
    @Autowired
    private SalesResourceService salesResourceService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private StudentService studentService;
/*跳转销售资源管理页面*/
    @RequestMapping("/sales/resourcesMang.do")
    public String resourcesMang() {
        return JumpView.SALES_RESOURESMANG_VIEW;
    }
/*查所有销售人员ByRoleid*/
    @RequestMapping("/resource/queryXiaoShouByRoleid.do")
    @ResponseBody
    public String queryXiaoShouByRoleid(String deptid) {
        List<Resource> list = salesResourceService.queryXiaoShouByRoleid(deptid);
        return JumpView.SALES_RESOURESMANG_VIEW;
    }

    /**
     * 跳转资源详细信息页面
     */
    @RequestMapping(value = "/resource/details.do", method = RequestMethod.GET)
    public String details(Model model, Integer resourceId) {
        if (resourceId != null) {
            List<Resource> list = resourceService.queryResourceByResourceId(resourceId);
            List<Visitrecord> record = salesResourceService.queryVisitrecordsByresourceId(resourceId);//回访记录信息
            model.addAttribute("resource", list);
            model.addAttribute("record", record);
        }
        return "sales/details";
    }
/*添加*/
    @RequestMapping("/resource/addDealrecord.do")
    @ResponseBody
    public String addDealrecord( Integer resourceId, Dealrecord dealrecord, Student student) {
        List<Resource> list = resourceService.queryResourceByResourceId(resourceId);
        int isStudent = list.get(0).getIsStudent();
        //把数据添加到student表中
        if (isStudent == 0) {//是否为学员  0资源 1学员
            list.get(0).setCourseid(dealrecord.getCourseid());//把从销售人员那里获取的课程id
            student = resourceToStudent(list.get(0),student);
            System.out.println("student:"+student);
            studentService.saveOrUpdate(student);
            return ReturnResult.SYSTEM_SUCCESS;
        }else{
            return ReturnResult.SYSTEM_NULL_ERROR;
        }
    }
    /**
     * 资源-->学员
     * @param resource
     * @param student
     * @return
     */
    public Student resourceToStudent(Resource resource,Student student){
        System.out.println(resource);
        if (resource != null) {
            student.setResourceId(resource.getResourceId());
            student.setUserid(resource.getUserid());
            student.setBelongid(resource.getBelongid());
            student.setStudentName(resource.getResourceName());
            student.setPhone(resource.getPhone());
            student.setAddress(resource.getAddress());
            student.setSex(resource.getSex());
            student.setSource(resource.getSource());
            student.setCourseid(resource.getCourseid());
            student.setResourceLevel(resource.getResourceLevel());
            student.setStudentstate(1);
            student.setIdCard(resource.getIdCard());
            student.setEmail(resource.getEmail());
            return student;
        }
        return null;
    }
    /*提交*/
    @RequestMapping("/student/studentCommit.do")
    @ResponseBody
    public String studentCommit(String resourceIds){
        int i = salesResourceService.studentCommit(resourceIds);
        if(i>0){
            return ReturnResult.SYSTEM_SUCCESS;
        }
        return ReturnResult.SYSTEM_NULL_ERROR;
    }
}
