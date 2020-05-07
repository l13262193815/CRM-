package com.hjcrm.controller.system;

import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.bean.SystemMessage;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.service.system.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
public class SystemMessageController {
    @Autowired
    private SystemMessageService systemMessageService;
    /*跳转消息管理页面*/
    @RequestMapping(value = "/system/systemMessage.do", method = RequestMethod.GET)
    public String systemMessage(Model model, HttpSession session){
        if (session.getAttribute("loginName") != null) {
            return JumpView.SYSTEM_MESSAGEMANG_VIEW;
        }
        return JumpView.SYSTEM_LOGIN_VIEW;//登录页面
    }
    /*查所有*/
    @RequestMapping("/system/querySystemmessages.do")
    @ResponseBody
    public String querySystemmessages(Integer currentPage,Integer pageSize){
        System.out.println("currentPage:" + currentPage);
        System.out.println("pageSize:" + pageSize);
        PageBean util = new PageBean();
        util.setCurrentPage((currentPage - 1) * pageSize);//起始位置
        util.setPageSize(pageSize);//查询条数
        List<SystemMessage> roles = systemMessageService.querySystemmessages(util);
        util.setCurrentPage(currentPage);
        util.setCountResult(systemMessageService.querySystemMessageCount());//获取总条数
        return JsonUtil.jsonToPage(roles, util);
    }
    /*添加、修改*/
    @RequestMapping(value = "/system/saveOrUpdateMessage.do", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrUpdateMessage(SystemMessage systemMessage) {
        int i = systemMessageService.saveOrUpdateMessage(systemMessage);
        return ReturnResult.SYSTEM_SUCCESS;
    }
    /*发布*/
    @RequestMapping(value = "/system/sendMessage.do", method = RequestMethod.GET)
    @ResponseBody
    public void sendMessage(SystemMessage systemMessage) {
        if(systemMessage.getIssend()!=1){
            //未发布
             int i = systemMessageService.sendMessage2(systemMessage);
        }else{//发布
             int i = systemMessageService.sendMessage(systemMessage);
        }
    }




}
