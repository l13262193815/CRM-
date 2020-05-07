package com.hjcrm.service.resource;

import com.hjcrm.bean.Resource;
import com.hjcrm.bean.User;
import com.hjcrm.bean.Visitrecord;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.constants.util.StateConstants;
import com.hjcrm.dao.resource.ResourceDao;
import com.hjcrm.dao.resource.SalesResourceDao;
import com.hjcrm.dao.system.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("resourceService")
public class ResourceService {
    @Autowired
    private ResourceDao resourceDao;

    public List<User> queryAllCreatePerson() {
        return resourceDao.queryAllCreatePerson();
    }

    public List<User> queryAllXiaoShou() {
        return resourceDao.queryAllXiaoShou();
    }

    /*查所有*/
    public List<Resource> queryResource(String userid, String roleid, String deptid, Integer currentPage, Integer pageSize) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userid", userid);
        param.put("deptid", deptid);
        param.put("roleid", roleid);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);

        List<Resource> list = resourceDao.queryResource(param);
        return list;
    }

    /*查总数*/
    public int queryResourceCount(String userid, String deptid, String roleid) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("deptid", deptid);
        param.put("roleid", roleid);
        param.put("userid", userid);
        return resourceDao.queryResourceCount(param);
    }

    @Autowired
    private SalesResourceDao salesResourceDao;

    public int addResource(Resource resource, Visitrecord visitrecord) {
        System.out.println("resource.getResourceId() :"+resource.getResourceId());
        if (resource.getResourceId() == 0) {
            System.out.println("add");
            return resourceDao.addResource(resource);//add
        } else if (visitrecord.getVisitRecord() == null) {
            System.out.println("update");
            return resourceDao.updateResource(resource);//update
        } else {
            System.out.println("xiangqing");
            List<Resource> list = resourceDao.queryResourceByResourceId(resource.getResourceId());
            int isStudent = list.get(0).getIsStudent();
            if (isStudent == 0) {//0表示资源
                int i = resourceDao.saveOrUpdate(resource);//修改资源表数据状态
            }
                Map<String, Object> map = new HashMap<>();
                int id = resource.getResourceId();
                String visitRecord = visitrecord.getVisitRecord();
                Timestamp create_time = visitrecord.getCreate_time();
                map.put("resourceId", id);
                map.put("visitRecord", visitRecord);
                map.put("create_time", create_time);
                return salesResourceDao.insertVisitrecords(map);
        }
}

    public int deleteResources(String resourceId) {
        List<String> list = new ArrayList<String>();
        for (String id : resourceId.split(",")) {//String[]
            list.add(id);
        }
        return resourceDao.deleteResources(list);
    }

    @Autowired
    UserDao userDao;

    public int assigntoResource(String resourceIds, String belongid, String states) {
        Resource r = new Resource();
        int i = 0;
        r.setBelongName(userDao.queryUserInfoById(Integer.parseInt(belongid)).getUsername());
        r.setBelongid(Integer.parseInt(belongid));
        r.setState(Integer.parseInt(states));
        for (String id : resourceIds.split(",")) {
            r.setResourceId(Integer.parseInt(id));
            i = resourceDao.assignResource(r);
        }
        return i;
    }

    public List<Resource> queryResourceByResourceId(Integer resourceId) {
        return resourceDao.queryResourceByResourceId(resourceId);
    }


    public int saveOrUpdate(Resource resource) {
        return resourceDao.saveOrUpdate(resource);
    }

}
