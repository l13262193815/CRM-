package com.hjcrm.dao.resource;

import com.hjcrm.bean.Resource;
import com.hjcrm.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> queryStudents(Object param);

    void saveOrUpdate(Student student);

   int returnStudent(List<String> list);

}
