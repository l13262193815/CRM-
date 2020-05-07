package com.hjcrm.bean;

import java.sql.Timestamp;
/*课程*/
public class Course {
            private int courseid;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '课程ID主键',
            private String courseName;//` varchar(100) DEFAULT NULL COMMENT '课程名称',
            private String coursecode;//` varchar(50) DEFAULT NULL COMMENT '课程编码',
            private String courseMoney;//` varchar(50) DEFAULT NULL COMMENT '课程价格',
            private String courseDescribe;//` varchar(200) DEFAULT NULL COMMENT '课程描述',
            private int courseTeacherid;//` bigint(20) DEFAULT NULL COMMENT '授课老师ID',
            private String courseTeacherName;//` varchar(50) DEFAULT NULL COMMENT '授课老师',
            private int create_id;//` bigint(20) DEFAULT NULL COMMENT '创建人',
            private Timestamp create_time;//` timestamp NULL DEFAULT NULL COMMENT '创建时间',
            private int update_id;//` bigint(20) DEFAULT NULL COMMENT '修改人',
            private Timestamp update_time;//` timestamp NULL DEFAULT NULL COMMENT '修改时间',
            private String note;//` varchar(200) DEFAULT NULL COMMENT '备注',
            private int dr;//` int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", courseName='" + courseName + '\'' +
                ", coursecode='" + coursecode + '\'' +
                ", courseMoney='" + courseMoney + '\'' +
                ", courseDescribe='" + courseDescribe + '\'' +
                ", courseTeacherid=" + courseTeacherid +
                ", courseTeacherName='" + courseTeacherName + '\'' +
                ", create_id=" + create_id +
                ", create_time=" + create_time +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                ", note='" + note + '\'' +
                ", dr=" + dr +
                '}';
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCourseMoney() {
        return courseMoney;
    }

    public void setCourseMoney(String courseMoney) {
        this.courseMoney = courseMoney;
    }

    public String getCourseDescribe() {
        return courseDescribe;
    }

    public void setCourseDescribe(String courseDescribe) {
        this.courseDescribe = courseDescribe;
    }

    public int getCourseTeacherid() {
        return courseTeacherid;
    }

    public void setCourseTeacherid(int courseTeacherid) {
        this.courseTeacherid = courseTeacherid;
    }

    public String getCourseTeacherName() {
        return courseTeacherName;
    }

    public void setCourseTeacherName(String courseTeacherName) {
        this.courseTeacherName = courseTeacherName;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public Course(int courseid, String courseName, String coursecode, String courseMoney, String courseDescribe, int courseTeacherid, String courseTeacherName, int create_id, Timestamp create_time, int update_id, Timestamp update_time, String note, int dr) {
        this.courseid = courseid;
        this.courseName = courseName;
        this.coursecode = coursecode;
        this.courseMoney = courseMoney;
        this.courseDescribe = courseDescribe;
        this.courseTeacherid = courseTeacherid;
        this.courseTeacherName = courseTeacherName;
        this.create_id = create_id;
        this.create_time = create_time;
        this.update_id = update_id;
        this.update_time = update_time;
        this.note = note;
        this.dr = dr;
    }

    public Course() {
    }
}
