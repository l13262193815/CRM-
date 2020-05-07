package com.hjcrm.service.patter;

import com.hjcrm.bean.Patter;
import com.hjcrm.bean.PatterType;
import com.hjcrm.dao.patter.PatterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patterService")
public class PatterService {
    @Autowired
    private PatterDao patterDao;

    /*查询场景名称*/
    public List<PatterType> queryPattertype(Patter patter) {
            return patterDao.queryPattertype(patter);
    }

    /*查询话术内容*/
    public List<Patter> queryPatter(Patter patter) {
        return patterDao.queryPatter(patter);
    }


    public int saveOrUpdatePatter(Patter patter) {
        if (patter.getRoleid() == 0 && patter.getCourseid() == 0) {//修改
            return patterDao.saveOrUpdatePatters(patter);
        } else {
            return patterDao.saveOrUpdatePatter(patter);//添加
        }
    }

    public int deletePatter(String userid, String patterids) {
        int i = patterDao.deletePatter(userid,patterids);
        return i;
    }

    public int updatePatterIsShare(String patterid) {
        return patterDao.updatePatterIsShare(patterid);
    }
}
