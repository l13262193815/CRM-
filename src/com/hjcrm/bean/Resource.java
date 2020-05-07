package com.hjcrm.bean;
import java.sql.Timestamp;
import java.util.List;
/*资源*/
public class Resource {
    private String courseName ;
    private int resourceId;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源主键ID',
    private int billno;// bigint(50) DEFAULT NULL COMMENT '单据号',
    private int userid;// bigint(20) DEFAULT NULL COMMENT '创建人id',
    private int deptid;// bigint(20) DEFAULT NULL COMMENT '创建人部门ID',
    private int belongid;// bigint(20) DEFAULT NULL COMMENT '分配销售人员ID',
    private String createrName;// varchar(20) DEFAULT NULL COMME NT '资源创建者姓名',
    private Timestamp create_time;// timestamp NULL DEFAULT NULL COMMENT '资源创建时间',
    private String resourceName;//varchar(20) DEFAULT NULL COMMENT '姓名',
    private String phone;//varchar(20) DEFAULT NULL COMMENT '手机号',
    private String tel;// varchar(20) DEFAULT NULL COMMENT '固定电话',
    private String weixin;// varchar(50) DEFAULT NULL COMMENT '微信',
    private String qq;//varchar(20) DEFAULT NULL COMMENT 'QQ号',
    private String address;// varchar(20) DEFAULT NULL COMMENT '地区',
    private int sex;// int(1) DEFAULT NULL COMMENT '性别 0男 1女',
    private int studentstate;// int(2) DEFAULT NULL COMMENT '学员状态 0新增 1已成交 2已提交 3已到账 4已分配 5已转入 6已通过考试 7已关课 8已退回',
    private int state;// int(3) DEFAULT '0' COMMENT '资源状态  0未分配 1已分配(未处理) 2已处理',
    private int isStudent;// int(1) DEFAULT '0' COMMENT '是否为学员  0资源 1学员',
    private int source;// int(3) DEFAULT NULL COMMENT '渠道: 0自建  1课程注册  2在线注册  3app下载注册   4电话咨询   5金考网注册用户   6线上渠道  7在线咨询  8大库资源 9 在线购买',
    private int courseid;// int(3) DEFAULT NULL COMMENT '咨询课程 0基金从业 1AFP 2CFP 3中级经济师 4期货从业 5证券从业 6银行初级 7初级会计师 8会计从业',
    private String yunYingResourceLevel;// varchar(2) DEFAULT NULL COMMENT '运营资源等级',
    private String resourceLevel;// varchar(2) DEFAULT NULL COMMENT '资源等级     A B C D',
    private Timestamp assignTime;// timestamp NULL DEFAULT NULL COMMENT '资源分配时间',
    private Timestamp firstVisitTime;// timestamp NULL DEFAULT NULL COMMENT '首次回访时间',
    private Timestamp nextVisitTime;// timestamp NULL DEFAULT NULL COMMENT '下次回访时间',
    private String yunYingNote;// varchar(300) DEFAULT NULL COMMENT '运营备注',
    private String xiaoShouNote;// varchar(200) DEFAULT NULL COMMENT '销售备注',
    private int update_id;// bigint(20) DEFAULT NULL COMMENT '修改人',
    private Timestamp update_time;// timestamp NULL DEFAULT NULL COMMENT '修改时间',
    private int dr;// int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',
    private String resourceColor;// varchar(100) DEFAULT NULL COMMENT '资源星级客户颜色',
    private int isolddata;// int(1) DEFAULT '0' COMMENT '是否历史数据 0否 1是',
    private int isZhuanyi;// int(1) DEFAULT '0' COMMENT '是否转移',
    private String idCard;// varchar(30) DEFAULT NULL COMMENT '身份证',
    private String email;// varchar(50) DEFAULT NULL COMMENT '邮箱',
    private String belongName;


    @Override
    public String toString() {
        return "Resource{" +
                "courseName='" + courseName + '\'' +
                ", resourceId=" + resourceId +
                ", billno=" + billno +
                ", userid=" + userid +
                ", deptid=" + deptid +
                ", belongid=" + belongid +
                ", createrName='" + createrName + '\'' +
                ", create_time=" + create_time +
                ", resourceName='" + resourceName + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", weixin='" + weixin + '\'' +
                ", qq='" + qq + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", studentstate=" + studentstate +
                ", state=" + state +
                ", isStudent=" + isStudent +
                ", source=" + source +
                ", courseid=" + courseid +
                ", yunYingResourceLevel='" + yunYingResourceLevel + '\'' +
                ", resourceLevel='" + resourceLevel + '\'' +
                ", assignTime=" + assignTime +
                ", firstVisitTime=" + firstVisitTime +
                ", nextVisitTime=" + nextVisitTime +
                ", yunYingNote='" + yunYingNote + '\'' +
                ", xiaoShouNote='" + xiaoShouNote + '\'' +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                ", dr=" + dr +
                ", resourceColor='" + resourceColor + '\'' +
                ", isolddata=" + isolddata +
                ", isZhuanyi=" + isZhuanyi +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", belongName='" + belongName + '\'' +

                '}';
    }


    public String getBelongName() {
        return belongName;
    }

    public void setBelongName(String belongName) {
        this.belongName = belongName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getBillno() {
        return billno;
    }

    public void setBillno(int billno) {
        this.billno = billno;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getBelongid() {
        return belongid;
    }

    public void setBelongid(int belongid) {
        this.belongid = belongid;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getStudentstate() {
        return studentstate;
    }

    public void setStudentstate(int studentstate) {
        this.studentstate = studentstate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(int isStudent) {
        this.isStudent = isStudent;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getYunYingResourceLevel() {
        return yunYingResourceLevel;
    }

    public void setYunYingResourceLevel(String yunYingResourceLevel) {
        this.yunYingResourceLevel = yunYingResourceLevel;
    }

    public String getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public Timestamp getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Timestamp assignTime) {
        this.assignTime = assignTime;
    }

    public Timestamp getFirstVisitTime() {
        return firstVisitTime;
    }

    public void setFirstVisitTime(Timestamp firstVisitTime) {
        this.firstVisitTime = firstVisitTime;
    }

    public Timestamp getNextVisitTime() {
        return nextVisitTime;
    }

    public void setNextVisitTime(Timestamp nextVisitTime) {
        this.nextVisitTime = nextVisitTime;
    }

    public String getYunYingNote() {
        return yunYingNote;
    }

    public void setYunYingNote(String yunYingNote) {
        this.yunYingNote = yunYingNote;
    }

    public String getXiaoShouNote() {
        return xiaoShouNote;
    }

    public void setXiaoShouNote(String xiaoShouNote) {
        this.xiaoShouNote = xiaoShouNote;
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

    public String getResourceColor() {
        return resourceColor;
    }

    public void setResourceColor(String resourceColor) {
        this.resourceColor = resourceColor;
    }

    public int getIsolddata() {
        return isolddata;
    }

    public void setIsolddata(int isolddata) {
        this.isolddata = isolddata;
    }

    public int getIsZhuanyi() {
        return isZhuanyi;
    }

    public void setIsZhuanyi(int isZhuanyi) {
        this.isZhuanyi = isZhuanyi;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Resource(int resourceId, int billno, int userid, int deptid, int belongid, String createrName, Timestamp create_time, String resourceName, String phone, String tel, String weixin, String qq, String address, int sex, int studentstate, int state, int isStudent, int source, int courseid, String yunYingResourceLevel, String resourceLevel, Timestamp assignTime, Timestamp firstVisitTime, Timestamp nextVisitTime, String yunYingNote, String xiaoShouNote, int update_id, Timestamp update_time, int dr, String resourceColor, int isolddata, int isZhuanyi, String idCard, String email) {
        this.resourceId = resourceId;
        this.billno = billno;
        this.userid = userid;
        this.deptid = deptid;
        this.belongid = belongid;
        this.createrName = createrName;
        this.create_time = create_time;
        this.resourceName = resourceName;
        this.phone = phone;
        this.tel = tel;
        this.weixin = weixin;
        this.qq = qq;
        this.address = address;
        this.sex = sex;
        this.studentstate = studentstate;
        this.state = state;
        this.isStudent = isStudent;
        this.source = source;
        this.courseid = courseid;
        this.yunYingResourceLevel = yunYingResourceLevel;
        this.resourceLevel = resourceLevel;
        this.assignTime = assignTime;
        this.firstVisitTime = firstVisitTime;
        this.nextVisitTime = nextVisitTime;
        this.yunYingNote = yunYingNote;
        this.xiaoShouNote = xiaoShouNote;
        this.update_id = update_id;
        this.update_time = update_time;
        this.dr = dr;
        this.resourceColor = resourceColor;
        this.isolddata = isolddata;
        this.isZhuanyi = isZhuanyi;
        this.idCard = idCard;
        this.email = email;
    }

    public Resource() {
    }
}
