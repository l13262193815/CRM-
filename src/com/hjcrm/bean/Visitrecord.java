package com.hjcrm.bean;

import java.sql.Timestamp;
/*回访记录表*/
public class Visitrecord {
    private int visitRecordid;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回访表主键ID',
    private int userid;// bigint(20) DEFAULT NULL COMMENT '销售或者客服id',
    private int resourceId;// bigint(20) DEFAULT NULL COMMENT '资源id',
    private int studentId;// bigint(20) DEFAULT NULL COMMENT '学员ID',
    private String visitRecord;// text COMMENT '回访记录内容',
    private Timestamp create_time;// timestamp NULL DEFAULT NULL COMMENT '创建时间',
    private Timestamp update_time;// timestamp NULL DEFAULT NULL COMMENT '修改时间',
    private int update_id;// bigint(20) DEFAULT NULL COMMENT '修改人id',
    private int dr;// int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',
    private int courseid;// bigint(20) DEFAULT NULL COMMENT '课程ID',
    private int subjectid;// bigint(20) DEFAULT NULL COMMENT '科目ID',

    @Override
    public String toString() {
        return "Visitrecord{" +
                "visitRecordid=" + visitRecordid +
                ", userid=" + userid +
                ", resourceId=" + resourceId +
                ", studentId=" + studentId +
                ", visitRecord='" + visitRecord + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                ", dr=" + dr +
                ", courseid=" + courseid +
                ", subjectid=" + subjectid +
                '}';
    }

    public int getVisitRecordid() {
        return visitRecordid;
    }

    public void setVisitRecordid(int visitRecordid) {
        this.visitRecordid = visitRecordid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getVisitRecord() {
        return visitRecord;
    }

    public void setVisitRecord(String visitRecord) {
        this.visitRecord = visitRecord;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public Visitrecord() {
    }

    public Visitrecord(int visitRecordid, int userid, int resourceId, int studentId, String visitRecord, Timestamp create_time, Timestamp update_time, int update_id, int dr, int courseid, int subjectid) {
        this.visitRecordid = visitRecordid;
        this.userid = userid;
        this.resourceId = resourceId;
        this.studentId = studentId;
        this.visitRecord = visitRecord;
        this.create_time = create_time;
        this.update_time = update_time;
        this.update_id = update_id;
        this.dr = dr;
        this.courseid = courseid;
        this.subjectid = subjectid;
    }
}
