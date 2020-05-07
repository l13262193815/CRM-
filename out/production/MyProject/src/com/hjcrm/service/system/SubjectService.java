package com.hjcrm.service.system;

import com.hjcrm.bean.Subject;
import com.hjcrm.constants.util.PageBean;
import com.hjcrm.dao.system.SubjectDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("subjectService")
public class SubjectService {
    @Autowired
    private SubjectDao subjectdao;

    public List<Subject> querySubject(PageBean util) {
        return subjectdao.querySubject(util);
    }

    public int querySubjectCount() {
        return subjectdao.querySubjectCount();
    }

    public int addOrUpdateSubject(Subject subject) {
        /*添加修改*/
        if ( subject.getSubjectid()== 0) {
            System.out.println("添加");
            return subjectdao.addOrUpdateSubject(subject);//添加
        } else {
            System.out.println("修改");
            return subjectdao.addOrUpdateSubjects(subject);//修改
        }
    }

    public int deleteSubject(String subjectids) {
        if (StringUtils.isNotBlank(subjectids)) {
            List<String> list = new ArrayList<String>();
            for (String id : subjectids.split(",")) {//String[]
                // for(元素类型 元素：数组名){语句体;}
                list.add(id);
            }
            return subjectdao.deleteSubject(list);
        }
        return -1;
    }

    public List<Subject> querySubjectByCourseid(Integer courseid) {
        return subjectdao.querySubjectByCourseid(courseid);
    }
}
