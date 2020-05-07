package com.hjcrm.service.resource;

import com.hjcrm.bean.Dealrecord;
import com.hjcrm.bean.Resource;
import com.hjcrm.bean.Visitrecord;
import com.hjcrm.dao.resource.SalesResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("salesresourceservice")
public class SalesResourceService {
    @Autowired
    private SalesResourceDao salesResourceDao;

    public List<Resource> queryXiaoShouByRoleid(String deptid) {
        return salesResourceDao.queryXiaoShouByRoleid(deptid);
    }
    public List<Visitrecord> queryVisitrecordsByresourceId( Integer resourceId) {
        Map<String,Object> map=new HashMap<>();
        map.put("resourceId",resourceId);
        return salesResourceDao.queryVisitrecordsByresourceId(map);
    }

    public int studentCommit(String resourceIds) {
        List<String> list=new ArrayList<>();
        for (String id:resourceIds.split(",")) {
            list.add(id);
        }
        return salesResourceDao.studentCommit(list);
    }


}
