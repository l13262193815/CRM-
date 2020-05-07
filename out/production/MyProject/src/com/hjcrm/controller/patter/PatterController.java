package com.hjcrm.controller.patter;

import com.hjcrm.bean.PatterType;
import com.hjcrm.constants.util.JsonUtil;
import com.hjcrm.bean.Patter;
import com.hjcrm.constants.JumpView;
import com.hjcrm.constants.ReturnResult;
import com.hjcrm.service.patter.PatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PatterController {
    @Autowired
    private PatterService patterService;
/*跳转页面*/
    @RequestMapping("/patter/myPatter.do")
    public String myPatter() {
        return JumpView.PATTER_PATTER_VIEW;
    }

    /*查询场景名称*/
    @RequestMapping("/patter/queryPattertype.do")
    @ResponseBody
    public String queryPattertype(Patter patter) {
        List<PatterType> list = patterService.queryPattertype(patter);
        return JsonUtil.jsonToPage(list, null);
    }
    /*查询话术内容*/
    @RequestMapping("/patter/queryPatter.do")
    @ResponseBody
    public String queryPatter(Patter patter) {
        List<Patter> list = patterService.queryPatter(patter);
        return JsonUtil.jsonToPage(list, null);
    }
    /*修改添加*/
    @RequestMapping("/patter/saveOrUpdatePatter.do")
    @ResponseBody
    public String saveOrUpdatePatter(Patter patter) {
        int i = patterService.saveOrUpdatePatter(patter);
        if (i > 0) {
            return ReturnResult.SYSTEM_SUCCESS;
        }
        return ReturnResult.SYSTEM_NULL_ERROR;
    }
    /*删除*/
    @RequestMapping("/patter/deletePatter.do")
    @ResponseBody
    public String deletePatter(String userid, String patterids) {
        int i = patterService.deletePatter(userid,patterids);
        if (i > 0) {
            return ReturnResult.SYSTEM_SUCCESS;
        }
        return ReturnResult.SYSTEM_NULL_ERROR;
    }
/*分享*/
@RequestMapping("/patter/updatePatterIsShare.do")
    @ResponseBody
    public String updatePatterIsShare(String patterid){
    int i = patterService.updatePatterIsShare(patterid);
    if (i > 0) {
        return ReturnResult.SYSTEM_SUCCESS;
    }
    return ReturnResult.SYSTEM_NULL_ERROR;
}

}
