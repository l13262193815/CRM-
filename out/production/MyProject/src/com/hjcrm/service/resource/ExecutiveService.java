package com.hjcrm.service.resource;

import com.hjcrm.bean.MatchInfo;
import com.hjcrm.dao.resource.ExecutiveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("executiveService")
public class ExecutiveService {
    @Autowired
    private ExecutiveDao executiveDao;

    public List<MatchInfo> queryxzCustoms() {
        return executiveDao.queryxzCustoms();
    }
    public List<MatchInfo> queryAllCustoms() {
        return executiveDao.queryAllCustoms();
    }
    public List<MatchInfo> queryYesStudentMatchinfo() {
        return executiveDao.queryYesStudentMatchinfo();
    }
}
