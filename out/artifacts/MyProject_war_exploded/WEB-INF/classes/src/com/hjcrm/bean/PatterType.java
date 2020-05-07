package com.hjcrm.bean;

import java.sql.Timestamp;
/*话术场景*/
public class PatterType {
            private int patterTypeId;//` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '话术场景类别主键',
            private String patterTypeName;//` varchar(100) DEFAULT NULL COMMENT '话术场景类别名称',
            private int courseid;//` bigint(20) DEFAULT NULL COMMENT '所属课程ID',
            private int create_id;//` bigint(20) DEFAULT NULL COMMENT '创建人',
            private Timestamp create_time;//` timestamp NULL DEFAULT NULL COMMENT '创建时间',
            private int update_id;//` bigint(20) DEFAULT NULL COMMENT '修改人',
            private Timestamp update_time;//` timestamp NULL DEFAULT NULL COMMENT '修改时间',
            private int dr;//int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',

    @Override
    public String toString() {
        return "PatterType{" +
                "patterTypeId=" + patterTypeId +
                ", patterTypeName='" + patterTypeName + '\'' +
                ", courseid=" + courseid +
                ", create_id=" + create_id +
                ", create_time=" + create_time +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                ", dr=" + dr +
                '}';
    }

    public int getPatterTypeId() {
        return patterTypeId;
    }

    public void setPatterTypeId(int patterTypeId) {
        this.patterTypeId = patterTypeId;
    }

    public String getPatterTypeName() {
        return patterTypeName;
    }

    public void setPatterTypeName(String patterTypeName) {
        this.patterTypeName = patterTypeName;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
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

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public PatterType(int patterTypeId, String patterTypeName, int courseid, int create_id, Timestamp create_time, int update_id, Timestamp update_time, int dr) {
        this.patterTypeId = patterTypeId;
        this.patterTypeName = patterTypeName;
        this.courseid = courseid;
        this.create_id = create_id;
        this.create_time = create_time;
        this.update_id = update_id;
        this.update_time = update_time;
        this.dr = dr;
    }

    public PatterType() {
    }
}
