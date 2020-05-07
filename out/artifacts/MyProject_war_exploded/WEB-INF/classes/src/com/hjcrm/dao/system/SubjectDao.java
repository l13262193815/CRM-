package com.hjcrm.dao.system;

import com.hjcrm.bean.Subject;
import com.hjcrm.constants.util.PageBean;

import java.util.List;

public interface SubjectDao {
    List<Subject> querySubject(PageBean util);

    int querySubjectCount();

    int addOrUpdateSubject(Subject subject);

    int addOrUpdateSubjects(Subject subject);

    int deleteSubject(List<String> list);

    List<Subject> querySubjectByCourseid(Integer courseid);
}
