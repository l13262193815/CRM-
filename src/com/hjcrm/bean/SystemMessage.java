package com.hjcrm.bean;
import java.sql.Timestamp;
/*消息*/
public class SystemMessage {
    private int systemmessageId;// bigint(20) NOT NULL AUTO_INCREMENT COMMENT '系统消息主键',
    private String messagetitle;// varchar(100) DEFAULT NULL COMMENT '消息标题',
    private String messageContent;// text COMMENT '消息内容',
    private int issend;// int(1) DEFAULT '0' COMMENT '是否发布 0未发布 1已发布',
    private Timestamp send_time;// timestamp NULL DEFAULT NULL COMMENT '消息发布时间',
    private Timestamp create_time;// timestamp NULL DEFAULT NULL COMMENT '创建时间',
    private int create_id;// bigint(20) DEFAULT NULL COMMENT '创建人',

    @Override
    public String toString() {
        return "SystemMessage{" +
                "systemmessageId=" + systemmessageId +
                ", messagetitle='" + messagetitle + '\'' +
                ", messageContent=" + messageContent +
                ", issend=" + issend +
                ", send_time=" + send_time +
                ", create_time=" + create_time +
                ", create_id=" + create_id +
                '}';
    }

    public int getSystemmessageId() {
        return systemmessageId;
    }

    public void setSystemmessageId(int systemmessageId) {
        this.systemmessageId = systemmessageId;
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public int getIssend() {
        return issend;
    }

    public void setIssend(int issend) {
        this.issend = issend;
    }

    public Timestamp getSend_time() {
        return send_time;
    }

    public void setSend_time(Timestamp send_time) {
        this.send_time = send_time;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public SystemMessage(int systemmessageId, String messagetitle, String messageContent, int issend, Timestamp send_time, Timestamp create_time, int create_id) {
        this.systemmessageId = systemmessageId;
        this.messagetitle = messagetitle;
        this.messageContent = messageContent;
        this.issend = issend;
        this.send_time = send_time;
        this.create_time = create_time;
        this.create_id = create_id;
    }

    public SystemMessage() {
    }
}
