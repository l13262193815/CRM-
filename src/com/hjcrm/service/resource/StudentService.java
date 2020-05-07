package com.hjcrm.service.resource;

import com.hjcrm.bean.Resource;
import com.hjcrm.bean.Student;
import com.hjcrm.dao.resource.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> queryStudents(String userid,String deptid,String roleid,Integer currentPage,Integer pageSize) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userid", userid);
        param.put("deptid", deptid);
        param.put("roleid", roleid);
        param.put("currentPage", currentPage);
        param.put("pageSize", pageSize);
        return studentDao.queryStudents(param);
    }

    public void saveOrUpdate(Student student) {
        studentDao.saveOrUpdate(student);
    }


    public int returnStudent(String resourceIds) {
        List<String> list=new ArrayList<>();
        for (String id:resourceIds.split(",")) {
            list.add(id);
        }
        return studentDao.returnStudent(list);
    }


}
