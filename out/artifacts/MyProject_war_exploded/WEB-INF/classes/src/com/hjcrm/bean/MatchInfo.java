package com.hjcrm.bean;

import java.util.Date;

public class MatchInfo {
    private int matchInfoId;//` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '到账信息主键ID',
    private String matchname;// varchar(100) DEFAULT NULL COMMENT '汇款人',
    private String payMoney;// varchar(100) DEFAULT NULL COMMENT '收款金额',
    private String payType;// varchar(50) DEFAULT NULL COMMENT '汇款方式',
    private Date receiveTime;// date DEFAULT NULL COMMENT '收款日期',
    private String matchnote;// varchar(200) DEFAULT NULL COMMENT '备注',
    private int ismatch;// int(1) DEFAULT '0' COMMENT '是否已匹配 0未匹配  1已匹配',
    private int dr;// int(1) DEFAULT '0' COMMENT '删除标志 0未删除 1已删除',
    private String studentName;// varchar(50) DEFAULT NULL COMMENT '确认到账对应的学员姓名',

    @Override
    public String toString() {
        return "MatchInfo{" +
                "matchInfoId=" + matchInfoId +
                ", matchname='" + matchname + '\'' +
                ", payMoney='" + payMoney + '\'' +
                ", payType='" + payType + '\'' +
                ", receiveTime=" + receiveTime +
                ", matchnote='" + matchnote + '\'' +
                ", ismatch=" + ismatch +
                ", dr=" + dr +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public int getMatchInfoId() {
        return matchInfoId;
    }

    public void setMatchInfoId(int matchInfoId) {
        this.matchInfoId = matchInfoId;
    }

    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getMatchnote() {
        return matchnote;
    }

    public void setMatchnote(String matchnote) {
        this.matchnote = matchnote;
    }

    public int getIsmatch() {
        return ismatch;
    }

    public void setIsmatch(int ismatch) {
        this.ismatch = ismatch;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public MatchInfo() {
    }

    public MatchInfo(int matchInfoId, String matchname, String payMoney, String payType, Date receiveTime, String matchnote, int ismatch, int dr, String studentName) {
        this.matchInfoId = matchInfoId;
        this.matchname = matchname;
        this.payMoney = payMoney;
        this.payType = payType;
        this.receiveTime = receiveTime;
        this.matchnote = matchnote;
        this.ismatch = ismatch;
        this.dr = dr;
        this.studentName = studentName;
    }
}
