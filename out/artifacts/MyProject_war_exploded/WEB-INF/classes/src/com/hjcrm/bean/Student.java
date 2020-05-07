package com.hjcrm.bean;

import java.sql.Timestamp;
/*学员*/
public class Student {
    private int studentId;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学员表主键id',
    private int resourceId;// bigint(20) DEFAULT NULL COMMENT '资源id',
    private int userid;// bigint(20) DEFAULT NULL COMMENT '创建人id',
    private int belongid;// bigint(20) DEFAULT NULL COMMENT '学员归属人ID',
    private int customerId;// bigint(20) DEFAULT NULL COMMENT '客服人员ID',
    private Timestamp customer_time;// timestamp NULL DEFAULT NULL COMMENT '分配客服时间',
    private String studentName;// varchar(20) DEFAULT NULL COMMENT '学员姓名',
    private String phone;// varchar(20) DEFAULT NULL COMMENT '学员手机号',
    private String tel;// varchar(30) DEFAULT NULL COMMENT '座机',
    private String weixin;// varchar(50) DEFAULT NULL COMMENT '微信号',
    private String qq;// varchar(20) DEFAULT NULL COMMENT 'QQ号',
    private String address;// varchar(50) DEFAULT NULL COMMENT '地区',
    private int sex;// int(1) DEFAULT NULL COMMENT '性别 0男 1女',
    private int source;// int(2) DEFAULT NULL COMMENT '渠道: 0自建  1课程注册  2在线注册  3app下载注册   4电话咨询   5金考网注册用户   6线上渠道  7在线咨询  8大库资源 9 在线购买',
    private String resourceLevel;// varchar(2) DEFAULT NULL COMMENT '资源等级     A B C D',
    private String idCard;// varchar(30) DEFAULT NULL COMMENT '身份证号码',
    private String nation;// varchar(10) DEFAULT NULL COMMENT '民族',
    private String education;// varchar(20) DEFAULT NULL COMMENT '学历',
    private String school;// varchar(50) DEFAULT NULL COMMENT '毕业院校',
    private String email;// varchar(50) DEFAULT NULL COMMENT '邮箱',
    private String company;// varchar(60) DEFAULT NULL COMMENT '工作单位',
    private String department;// varchar(50) DEFAULT NULL COMMENT '工作部门',
    private String position;// varchar(50) DEFAULT NULL COMMENT '职务',
    private String companyAddr;// varchar(100) DEFAULT NULL COMMENT '公司地址',
    private String homeAddr;// varchar(100) DEFAULT NULL COMMENT '家庭住址',
    private String companyTel;// varchar(30) DEFAULT NULL COMMENT '公司电话',
    private int isjieye;// int(1) DEFAULT '0' COMMENT '是否协助结业 0：否 1：是',
    private String LCWname;// varchar(80) DEFAULT NULL COMMENT '理财网用户名',
    private String LCWpassword;// varchar(80) DEFAULT NULL COMMENT '理财网密码',
    private Timestamp LCWoutTime;// timestamp NULL DEFAULT NULL COMMENT '理财网过期时间',
    private String banci;// varchar(30) DEFAULT NULL COMMENT '班次',
    private String classNum;// varchar(20) DEFAULT NULL COMMENT '上课班号',
    private String qici;//varchar(30) DEFAULT NULL COMMENT '期次',
    private int isSignAgreement;// int(1) DEFAULT '0' COMMENT '是否签订协议 0未签订 1已签订',
    private int studentstate;// int(2) DEFAULT NULL COMMENT '学员状态 0新增 1已成交 2已提交 3已到账 4已分配 5已转入 6已通过考试 7已关课 8已退回',
    private String courseversion;// varchar(30) DEFAULT NULL COMMENT '课件版本',
    private Timestamp mailTime;// timestamp NULL DEFAULT NULL COMMENT '邮寄时间',
    private int isHaveCourse;// int(1) DEFAULT '0' COMMENT '是否上过课 0未上过课 1已上过课',
    private String kefuNote1;// varchar(200) DEFAULT NULL COMMENT '客服备注1',
    private String kefuNote2;// varchar(200) DEFAULT NULL COMMENT '客服备注2',
    private String baokaopassword;// varchar(50) DEFAULT NULL COMMENT '报考密码',
    private int dr;// int(1) DEFAULT '0' COMMENT '删除标志 0未删除  1已删除',
    private String returnNote;// varchar(200) DEFAULT NULL COMMENT '退回原因',
    private Timestamp returnTime;// timestamp NULL DEFAULT NULL COMMENT '退回时间',
    private int returnId;// bigint(20) DEFAULT NULL COMMENT '退回人',
    private Timestamp create_time;// timestamp NULL DEFAULT NULL COMMENT '创建时间',
    private int update_id;// bigint(20) DEFAULT NULL COMMENT '修改人',
    private Timestamp update_time;// timestamp NULL DEFAULT NULL COMMENT '修改时间',
    private Timestamp commit_time;// timestamp NULL DEFAULT NULL COMMENT '提交行政日期',
    private String headmaster;// varchar(30) DEFAULT NULL COMMENT '班主任',
    private int courseid;// bigint(20) DEFAULT NULL COMMENT '课程ID',
    private Timestamp matchinfo_time;// timestamp NULL DEFAULT NULL COMMENT '确认到账时间',
    private String arrive_money;// varchar(100) DEFAULT NULL COMMENT '收款金额',
    private String arrive_time;// varchar(100) DEFAULT NULL COMMENT '收款时间',
    private String preferinfo;// varchar(100) DEFAULT NULL COMMENT '优惠信息',
    private int ishavenetedu;// int(1) DEFAULT '0' COMMENT '是否存在网络培训费 0无 1有',
    private String netedumoney;// varchar(30) DEFAULT NULL COMMENT '网络培训费金额',
    private String remitWay;// varchar(50) DEFAULT NULL COMMENT '汇款方式',
    private String remituser;// varchar(300) DEFAULT NULL COMMENT '代汇款人',
    private String invoiceinfo;// varchar(200) DEFAULT NULL COMMENT '发票情况',
    private int ispass;// int(1) DEFAULT '0' COMMENT '是否通过 0未通过 1通过 2缺考',
    private Timestamp passtime;//timestamp NULL DEFAULT NULL COMMENT '通过时间',
    private Timestamp dealtime;// timestamp NULL DEFAULT NULL COMMENT '成交时间',
    private String dealprice;//varchar(20) DEFAULT NULL COMMENT '成交金额',
    private int iscommitcaiwu;// int(1) DEFAULT '0' COMMENT '行政是否提交财务 0未提交 1已提交',
    private String commitTime_caiwu;// timestamp NULL DEFAULT NULL COMMENT '行政提交财务时间',
    private String paytime;// varchar(30) DEFAULT NULL COMMENT '支付日期',
    private String xingzhengNote;// varchar(200) DEFAULT NULL COMMENT '行政备注',
    private Timestamp scoretime;//timestamp NULL DEFAULT NULL COMMENT '考试日期',
    private String studentEvaluate;// varchar(10) DEFAULT NULL COMMENT '学员评价   优 良 中 差',
    private String specialinfov;// varchar(20) DEFAULT NULL COMMENT '特殊情况',
    private String studentColor;// varchar(100) DEFAULT NULL COMMENT '学员颜色标记',
    private String xiaoShouNote;// varchar(200) DEFAULT NULL COMMENT '销售备注',
    private int isOnlineBuy;// int(1) NOT NULL DEFAULT '0' COMMENT '是否在线购买 0:否 1:是',
    private int isolddata;// int(1) DEFAULT '0' COMMENT '是否历史数据  0否 1是',
    private String customerName;
    private String belongName;//归属者姓名/招生老师
    private String sumPayMoney;//归属者姓名/招生老师
private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSumPayMoney() {
        return sumPayMoney;
    }

    public void setSumPayMoney(String sumPayMoney) {
        this.sumPayMoney = sumPayMoney;
    }

    public String getBelongName() {
        return belongName;
    }

    public void setBelongName(String belongName) {
        this.belongName = belongName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", resourceId=" + resourceId +
                ", userid=" + userid +
                ", belongid=" + belongid +
                ", customerId=" + customerId +
                ", customer_time=" + customer_time +
                ", studentName='" + studentName + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", weixin='" + weixin + '\'' +
                ", qq='" + qq + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", source=" + source +
                ", resourceLevel='" + resourceLevel + '\'' +
                ", idCard='" + idCard + '\'' +
                ", nation='" + nation + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", companyAddr='" + companyAddr + '\'' +
                ", homeAddr='" + homeAddr + '\'' +
                ", companyTel='" + companyTel + '\'' +
                ", isjieye=" + isjieye +
                ", LCWname='" + LCWname + '\'' +
                ", LCWpassword='" + LCWpassword + '\'' +
                ", LCWoutTime=" + LCWoutTime +
                ", banci='" + banci + '\'' +
                ", classNum='" + classNum + '\'' +
                ", qici='" + qici + '\'' +
                ", isSignAgreement=" + isSignAgreement +
                ", studentstate=" + studentstate +
                ", courseversion='" + courseversion + '\'' +
                ", mailTime=" + mailTime +
                ", isHaveCourse=" + isHaveCourse +
                ", kefuNote1='" + kefuNote1 + '\'' +
                ", kefuNote2='" + kefuNote2 + '\'' +
                ", baokaopassword='" + baokaopassword + '\'' +
                ", dr=" + dr +
                ", returnNote='" + returnNote + '\'' +
                ", returnTime=" + returnTime +
                ", returnId=" + returnId +
                ", create_time=" + create_time +
                ", update_id=" + update_id +
                ", update_time=" + update_time +
                ", commit_time=" + commit_time +
                ", headmaster='" + headmaster + '\'' +
                ", courseid=" + courseid +
                ", matchinfo_time=" + matchinfo_time +
                ", arrive_money='" + arrive_money + '\'' +
                ", arrive_time='" + arrive_time + '\'' +
                ", preferinfo='" + preferinfo + '\'' +
                ", ishavenetedu=" + ishavenetedu +
                ", netedumoney='" + netedumoney + '\'' +
                ", remitWay='" + remitWay + '\'' +
                ", remituser='" + remituser + '\'' +
                ", invoiceinfo='" + invoiceinfo + '\'' +
                ", ispass=" + ispass +
                ", passtime=" + passtime +
                ", dealtime=" + dealtime +
                ", dealprice='" + dealprice + '\'' +
                ", iscommitcaiwu=" + iscommitcaiwu +
                ", commitTime_caiwu='" + commitTime_caiwu + '\'' +
                ", paytime='" + paytime + '\'' +
                ", xingzhengNote='" + xingzhengNote + '\'' +
                ", scoretime=" + scoretime +
                ", studentEvaluate='" + studentEvaluate + '\'' +
                ", specialinfov='" + specialinfov + '\'' +
                ", studentColor='" + studentColor + '\'' +
                ", xiaoShouNote='" + xiaoShouNote + '\'' +
                ", isOnlineBuy=" + isOnlineBuy +
                ", isolddata=" + isolddata +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBelongid() {
        return belongid;
    }

    public void setBelongid(int belongid) {
        this.belongid = belongid;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getCustomer_time() {
        return customer_time;
    }

    public void setCustomer_time(Timestamp customer_time) {
        this.customer_time = customer_time;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public String getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(String resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public int getIsjieye() {
        return isjieye;
    }

    public void setIsjieye(int isjieye) {
        this.isjieye = isjieye;
    }

    public String getLCWname() {
        return LCWname;
    }

    public void setLCWname(String LCWname) {
        this.LCWname = LCWname;
    }

    public String getLCWpassword() {
        return LCWpassword;
    }

    public void setLCWpassword(String LCWpassword) {
        this.LCWpassword = LCWpassword;
    }

    public Timestamp getLCWoutTime() {
        return LCWoutTime;
    }

    public void setLCWoutTime(Timestamp LCWoutTime) {
        this.LCWoutTime = LCWoutTime;
    }

    public String getBanci() {
        return banci;
    }

    public void setBanci(String banci) {
        this.banci = banci;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getQici() {
        return qici;
    }

    public void setQici(String qici) {
        this.qici = qici;
    }

    public int getIsSignAgreement() {
        return isSignAgreement;
    }

    public void setIsSignAgreement(int isSignAgreement) {
        this.isSignAgreement = isSignAgreement;
    }

    public int getStudentstate() {
        return studentstate;
    }

    public void setStudentstate(int studentstate) {
        this.studentstate = studentstate;
    }

    public String getCourseversion() {
        return courseversion;
    }

    public void setCourseversion(String courseversion) {
        this.courseversion = courseversion;
    }

    public Timestamp getMailTime() {
        return mailTime;
    }

    public void setMailTime(Timestamp mailTime) {
        this.mailTime = mailTime;
    }

    public int getIsHaveCourse() {
        return isHaveCourse;
    }

    public void setIsHaveCourse(int isHaveCourse) {
        this.isHaveCourse = isHaveCourse;
    }

    public String getKefuNote1() {
        return kefuNote1;
    }

    public void setKefuNote1(String kefuNote1) {
        this.kefuNote1 = kefuNote1;
    }

    public String getKefuNote2() {
        return kefuNote2;
    }

    public void setKefuNote2(String kefuNote2) {
        this.kefuNote2 = kefuNote2;
    }

    public String getBaokaopassword() {
        return baokaopassword;
    }

    public void setBaokaopassword(String baokaopassword) {
        this.baokaopassword = baokaopassword;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public String getReturnNote() {
        return returnNote;
    }

    public void setReturnNote(String returnNote) {
        this.returnNote = returnNote;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
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

    public Timestamp getCommit_time() {
        return commit_time;
    }

    public void setCommit_time(Timestamp commit_time) {
        this.commit_time = commit_time;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public Timestamp getMatchinfo_time() {
        return matchinfo_time;
    }

    public void setMatchinfo_time(Timestamp matchinfo_time) {
        this.matchinfo_time = matchinfo_time;
    }

    public String getArrive_money() {
        return arrive_money;
    }

    public void setArrive_money(String arrive_money) {
        this.arrive_money = arrive_money;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getPreferinfo() {
        return preferinfo;
    }

    public void setPreferinfo(String preferinfo) {
        this.preferinfo = preferinfo;
    }

    public int getIshavenetedu() {
        return ishavenetedu;
    }

    public void setIshavenetedu(int ishavenetedu) {
        this.ishavenetedu = ishavenetedu;
    }

    public String getNetedumoney() {
        return netedumoney;
    }

    public void setNetedumoney(String netedumoney) {
        this.netedumoney = netedumoney;
    }

    public String getRemitWay() {
        return remitWay;
    }

    public void setRemitWay(String remitWay) {
        this.remitWay = remitWay;
    }

    public String getRemituser() {
        return remituser;
    }

    public void setRemituser(String remituser) {
        this.remituser = remituser;
    }

    public String getInvoiceinfo() {
        return invoiceinfo;
    }

    public void setInvoiceinfo(String invoiceinfo) {
        this.invoiceinfo = invoiceinfo;
    }

    public int getIspass() {
        return ispass;
    }

    public void setIspass(int ispass) {
        this.ispass = ispass;
    }

    public Timestamp getPasstime() {
        return passtime;
    }

    public void setPasstime(Timestamp passtime) {
        this.passtime = passtime;
    }

    public Timestamp getDealtime() {
        return dealtime;
    }

    public void setDealtime(Timestamp dealtime) {
        this.dealtime = dealtime;
    }

    public String getDealprice() {
        return dealprice;
    }

    public void setDealprice(String dealprice) {
        this.dealprice = dealprice;
    }

    public int getIscommitcaiwu() {
        return iscommitcaiwu;
    }

    public void setIscommitcaiwu(int iscommitcaiwu) {
        this.iscommitcaiwu = iscommitcaiwu;
    }

    public String getCommitTime_caiwu() {
        return commitTime_caiwu;
    }

    public void setCommitTime_caiwu(String commitTime_caiwu) {
        this.commitTime_caiwu = commitTime_caiwu;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getXingzhengNote() {
        return xingzhengNote;
    }

    public void setXingzhengNote(String xingzhengNote) {
        this.xingzhengNote = xingzhengNote;
    }

    public Timestamp getScoretime() {
        return scoretime;
    }

    public void setScoretime(Timestamp scoretime) {
        this.scoretime = scoretime;
    }

    public String getStudentEvaluate() {
        return studentEvaluate;
    }

    public void setStudentEvaluate(String studentEvaluate) {
        this.studentEvaluate = studentEvaluate;
    }

    public String getSpecialinfov() {
        return specialinfov;
    }

    public void setSpecialinfov(String specialinfov) {
        this.specialinfov = specialinfov;
    }

    public String getStudentColor() {
        return studentColor;
    }

    public void setStudentColor(String studentColor) {
        this.studentColor = studentColor;
    }

    public String getXiaoShouNote() {
        return xiaoShouNote;
    }

    public void setXiaoShouNote(String xiaoShouNote) {
        this.xiaoShouNote = xiaoShouNote;
    }

    public int getIsOnlineBuy() {
        return isOnlineBuy;
    }

    public void setIsOnlineBuy(int isOnlineBuy) {
        this.isOnlineBuy = isOnlineBuy;
    }

    public int getIsolddata() {
        return isolddata;
    }

    public void setIsolddata(int isolddata) {
        this.isolddata = isolddata;
    }

    public Student(int studentId, int resourceId, int userid, int belongid, int customerId, Timestamp customer_time, String studentName, String phone, String tel, String weixin, String qq, String address, int sex, int source, String resourceLevel, String idCard, String nation, String education, String school, String email, String company, String department, String position, String companyAddr, String homeAddr, String companyTel, int isjieye, String LCWname, String LCWpassword, Timestamp LCWoutTime, String banci, String classNum, String qici, int isSignAgreement, int studentstate, String courseversion, Timestamp mailTime, int isHaveCourse, String kefuNote1, String kefuNote2, String baokaopassword, int dr, String returnNote, Timestamp returnTime, int returnId, Timestamp create_time, int update_id, Timestamp update_time, Timestamp commit_time, String headmaster, int courseid, Timestamp matchinfo_time, String arrive_money, String arrive_time, String preferinfo, int ishavenetedu, String netedumoney, String remitWay, String remituser, String invoiceinfo, int ispass, Timestamp passtime, Timestamp dealtime, String dealprice, int iscommitcaiwu, String commitTime_caiwu, String paytime, String xingzhengNote, Timestamp scoretime, String studentEvaluate, String specialinfov, String studentColor, String xiaoShouNote, int isOnlineBuy, int isolddata) {
        this.studentId = studentId;
        this.resourceId = resourceId;
        this.userid = userid;
        this.belongid = belongid;
        this.customerId = customerId;
        this.customer_time = customer_time;
        this.studentName = studentName;
        this.phone = phone;
        this.tel = tel;
        this.weixin = weixin;
        this.qq = qq;
        this.address = address;
        this.sex = sex;
        this.source = source;
        this.resourceLevel = resourceLevel;
        this.idCard = idCard;
        this.nation = nation;
        this.education = education;
        this.school = school;
        this.email = email;
        this.company = company;
        this.department = department;
        this.position = position;
        this.companyAddr = companyAddr;
        this.homeAddr = homeAddr;
        this.companyTel = companyTel;
        this.isjieye = isjieye;
        this.LCWname = LCWname;
        this.LCWpassword = LCWpassword;
        this.LCWoutTime = LCWoutTime;
        this.banci = banci;
        this.classNum = classNum;
        this.qici = qici;
        this.isSignAgreement = isSignAgreement;
        this.studentstate = studentstate;
        this.courseversion = courseversion;
        this.mailTime = mailTime;
        this.isHaveCourse = isHaveCourse;
        this.kefuNote1 = kefuNote1;
        this.kefuNote2 = kefuNote2;
        this.baokaopassword = baokaopassword;
        this.dr = dr;
        this.returnNote = returnNote;
        this.returnTime = returnTime;
        this.returnId = returnId;
        this.create_time = create_time;
        this.update_id = update_id;
        this.update_time = update_time;
        this.commit_time = commit_time;
        this.headmaster = headmaster;
        this.courseid = courseid;
        this.matchinfo_time = matchinfo_time;
        this.arrive_money = arrive_money;
        this.arrive_time = arrive_time;
        this.preferinfo = preferinfo;
        this.ishavenetedu = ishavenetedu;
        this.netedumoney = netedumoney;
        this.remitWay = remitWay;
        this.remituser = remituser;
        this.invoiceinfo = invoiceinfo;
        this.ispass = ispass;
        this.passtime = passtime;
        this.dealtime = dealtime;
        this.dealprice = dealprice;
        this.iscommitcaiwu = iscommitcaiwu;
        this.commitTime_caiwu = commitTime_caiwu;
        this.paytime = paytime;
        this.xingzhengNote = xingzhengNote;
        this.scoretime = scoretime;
        this.studentEvaluate = studentEvaluate;
        this.specialinfov = specialinfov;
        this.studentColor = studentColor;
        this.xiaoShouNote = xiaoShouNote;
        this.isOnlineBuy = isOnlineBuy;
        this.isolddata = isolddata;
    }

    public Student() {
    }
}
