package com.hjcrm.service.system;

import com.hjcrm.constants.util.PageBean;
import com.hjcrm.bean.Course;
import com.hjcrm.dao.system.CourseDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseService")
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    public List<Course> queryCourses(PageBean util) {
        return courseDao.queryCourses(util);
    }

    public int queryCourseCount() {
        return courseDao.queryCourseCount();
    }

    public int addCourse(Course course) {
        /*添加修改*/
        if (course.getCourseid() == 0) {
            System.out.println("添加");
            return courseDao.addCourse(course);//添加
        } else {
            System.out.println("修改");
            return courseDao.addCourses(course);//修改
        }
}

    public int deleteCourse(String courseids) {
        if (StringUtils.isNotBlank(courseids)) {
            List<String> list = new ArrayList<String>();
            for (String id : courseids.split(",")) {//String[]
                // for(元素类型 元素：数组名){语句体;}
                list.add(id);
            }
            return courseDao.deleteCourse(list);
        }
        return -1;
    }

    public List<Course> queryCourse() {
        return courseDao.queryCourse();
    }

    public Course queryCourseById(int courseid) {
        return courseDao.queryCourseById(courseid);
    }
}
