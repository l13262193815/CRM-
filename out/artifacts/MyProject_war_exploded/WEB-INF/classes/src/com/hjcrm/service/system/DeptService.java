package com.hjcrm.service.system;

import com.hjcrm.constants.util.PageBean;
import com.hjcrm.dao.system.DeptDao;
import com.hjcrm.bean.Dept;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("deptService")
public class DeptService {
    @Autowired
    private DeptDao deptDao;
/*部门管理全查询操作*/
    public List<Dept> queryAllDeptInfo(PageBean pageBean) {
        List<Dept> depts = deptDao.queryAllDeptInfo(pageBean);
        return depts;
    }
/*用户中全查询操作*/
    public List<Dept> queryAllDeptInfos() {
        return deptDao.queryAllDeptInfos();
    }


    public int queryAllDeptInfoCount() {
        return deptDao.queryAllDeptInfoCount();
    }
    public int saveOrUpdate(Dept dept) {
        if(dept.getDeptid()==0) {//add
            return deptDao.saveOrUpdate(dept);//添加
        }else{
            return deptDao.saveOrUpdates(dept);//修改
        }
    }

    public int delete(String ids) {
        if (StringUtils.isNotBlank(ids)) {
            List<String> list = new ArrayList<String>();
            for (String id : ids.split(",")) {//String[]
                // for(元素类型 元素：数组名){语句体;}
                list.add(id);
            }
            return deptDao.delete(list);
        }
        return -1;
    }
}
