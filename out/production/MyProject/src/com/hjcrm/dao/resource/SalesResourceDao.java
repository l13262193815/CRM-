package com.hjcrm.dao.resource;

import com.hjcrm.bean.Dealrecord;
import com.hjcrm.bean.Resource;
import com.hjcrm.bean.Visitrecord;

import java.util.List;
import java.util.Map;

public interface SalesResourceDao {
    List<Resource> queryXiaoShouByRoleid(String deptid);

    List<Visitrecord> queryVisitrecordsByresourceId(Map<String, Object> map);

    int insertVisitrecords(Map<String,Object> map);

    int studentCommit(List<String> list);
}
