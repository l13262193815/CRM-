package com.hjcrm.dao.resource;

import com.hjcrm.bean.MatchInfo;

import java.util.List;

public interface ExecutiveDao {
    List<MatchInfo> queryxzCustoms();
    List<MatchInfo> queryAllCustoms();
    List<MatchInfo> queryYesStudentMatchinfo();
}
