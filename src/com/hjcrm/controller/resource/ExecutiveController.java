package com.hjcrm.controller.resource;

import com.hjcrm.bean.MatchInfo;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.service.resource.ExecutiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*行政部*/
@Controller
public class ExecutiveController {
    @Autowired
    private ExecutiveService executiveService;
    @RequestMapping("/executive/studentMang.do")
    public String studentMang(){
        return JumpView.EXECUTIVE_STUDENT_VIEW;
    }
    /**
     * 到账学院总表界面（行政部）
     */
    @RequestMapping("/executive/accountStudent.do")
    public String accountStudent(){
        return JumpView.EXECUTIVE_ACCOUNTSTUDENT;//行政部-总表信息页面;
    }
    /**
     * 跳转学员关课界面（行政部）
     */
    @RequestMapping(value = "/executive/colseCourse.do", method = RequestMethod.GET)
    public String colseCourseIndex(Model model){
        return JumpView.EXECUTIVE_COLSECOURSE;//行政部-学员关课页面
    }
    /*到账学员总表*/
   @RequestMapping("/custom/queryxzCustoms.do")
    @ResponseBody
    public String queryxzCustoms(){
        List<MatchInfo> list=executiveService.queryxzCustoms();
        return JsonUtil.jsonToPage(list,null);
   }
   @RequestMapping("/custom/queryAllCustoms.do")
    @ResponseBody
    public String queryAllCustoms(){
        List<MatchInfo> list=executiveService.queryAllCustoms();
        return JsonUtil.jsonToPage(list,null);
   }
   @RequestMapping("/student/queryYesStudentMatchinfo.do")
    @ResponseBody
    public String queryYesStudentMatchinfo(){
        List<MatchInfo> list=executiveService.queryYesStudentMatchinfo();
        return JsonUtil.jsonToPage(list,null);
   }
}
