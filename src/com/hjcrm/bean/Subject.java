package com.hjcrm.bean;

import java.sql.Timestamp;
/*科目*/
public class Subject {
            private int subjectid;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '科目主键ID',
            private int courseid;//bigint(20) DEFAULT NULL COMMENT '所属课程ID',
            private String subjectname ;//int  varchar(100) DEFAULT NULL COMMENT '科目名称',
            private String subjectcode ;// varchar(50) DEFAULT NULL COMMENT '科目编码',
            private int create_id;// bigint(20) DEFAULT NULL COMMENT '创建人',
            private Timestamp create_time;// timestamp NULL DEFAULT NULL COMMENT '创建时间',
            private int update_id;// bigint(20) DEFAULT NULL COMMENT '修改人',
            private Timestamp update_time;// timestamp NULL DEFAULT NULL COMMENT '修改时间',
            private String note;// varchar(200) DEFAULT NULL COMMENT '备注',
            private int dr;// int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',
private String courseName;

    public Subject(int subjectid, int courseid, String subjectname, String subjectcode, int create_id, Timestamp create_time, int update_id, Timestamp update_time, String note, int dr, String courseName) {
        this.subjectid = subjectid;
        this.courseid = courseid;
        this.subjectname = subjectname;
        this.subjectcode = subjectcode;
        this.create_id = create_id;
        this.create_time = create_time;
        this.update_id = update_id;
        this.update_time = update_time;
        this.note = note;
        this.dr = dr;
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
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

    @Override
    public String toString() {
        return "Subject{" +
                "subjectid=" + subjectid +
                ", courseid=" + courseid +
                ", subjectname='" + subjectname + '\'' +
                ", subjectcode='" + subjectcode + '\'' +
                ", create_id=" + create_id +
                ", create_time=" + create_time +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                ", note='" + note + '\'' +
                ", dr=" + dr +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public Subject() {
    }
}
