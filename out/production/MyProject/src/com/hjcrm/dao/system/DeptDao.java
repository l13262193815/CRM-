package com.hjcrm.dao.system;

import com.hjcrm.constants.util.PageBean;
import com.hjcrm.bean.Dept;

import java.util.List;

public interface DeptDao {
    public List<Dept> queryAllDeptInfo(PageBean pageBean);//带分页
    public List<Dept> queryAllDeptInfos();//不带分页
/*添加*/
    int saveOrUpdate(Dept dept);
/*修改*/
    int saveOrUpdates(Dept dept);

    int delete(List<String> list);

    int queryAllDeptInfoCount();
}
