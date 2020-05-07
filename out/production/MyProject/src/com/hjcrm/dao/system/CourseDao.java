package com.hjcrm.dao.system;

import com.hjcrm.bean.Course;
import com.hjcrm.constants.util.PageBean;

import java.util.List;

public interface CourseDao {

    List<Course> queryCourse();//全查询
    List<Course> queryCourses(PageBean util);//分页

    int queryCourseCount();

    int addCourse(Course course);

    int addCourses(Course course);

    int deleteCourse(List<String> list);

    Course queryCourseById(int courseid);
}
