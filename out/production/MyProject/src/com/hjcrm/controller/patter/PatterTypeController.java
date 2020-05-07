package com.hjcrm.controller.patter;

import com.hjcrm.bean.PatterType;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.service.patter.PatterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PatterTypeController {
    @Autowired
    private PatterTypeService patterTypeService;

    /*显示话术场景页面*/
    @RequestMapping("/system/patterType.do")
    public String patterType() {
        return JumpView.PATTER_PATTERTYPE_VIEW;
    }

    /*查所有*/
    @RequestMapping("/course/queryPattertype.do")
    @ResponseBody
    public String queryPattertype() {
        List<PatterType> list = patterTypeService.queryPattertype();
        return JsonUtil.jsonToPage(list, null);
    }

    /*添加*/
    @RequestMapping("/course/addPattertype.do")
    @ResponseBody
    public String addPattertype(PatterType patterType) {
        int i = patterTypeService.addPattertype(patterType);
        if (i > 0) {
            return ReturnResult.SYSTEM_SUCCESS;
        }
        return ReturnResult.SYSTEM_NULL_ERROR;
    }
    /*删除*/
    @RequestMapping("/course/deletepatterType.do")
    @ResponseBody
    public void deletepatterType(String patterTypeIds){
        int i = patterTypeService.deletepatterType(patterTypeIds);
    }
}
