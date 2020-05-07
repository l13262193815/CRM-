package com.hjcrm.dao.resource;

import com.hjcrm.bean.Resource;
import com.hjcrm.bean.User;

import java.util.List;
import java.util.Map;

public interface ResourceDao {

    List<User> queryAllCreatePerson();

    List<User> queryAllXiaoShou();

    List<Resource> queryResource(Object param);

    int queryResourceCount(Map<String, Object> param);

    int addResource(Resource resource);

    int updateResource(Resource resource);

    int deleteResources(List<String> list);

    int assignResource(Resource resource);

    List<Resource> queryResourceByResourceId(Integer resourceId);

    int saveOrUpdate(Resource resource);
}
