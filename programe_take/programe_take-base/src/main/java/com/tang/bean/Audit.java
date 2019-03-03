package com.tang.bean;

import java.util.Date;
import java.util.List;

/**
 * @author Tang
 * @create 2019-01-30 15:29:48
 */
public class Audit {

	private Integer id;

	private Integer uid;

	private Integer aid;
//  审核状态  0 未审核   1以审核
	private Integer status;

	private String adminMessage;

	private Date auditTime;

	private Article article;

	private User user;

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

	public Integer getUid() {
        return this.uid;
    }

	public void setUid(Integer uid) {
        this.uid = uid;
    }

	public Integer getAid() {
        return this.aid;
    }

	public void setAid(Integer aid) {
        this.aid = aid;
    }

	public Integer getStatus() {
        return this.status;
    }

	public void setStatus(Integer status) {
        this.status = status;
    }

	public String getAdminMessage() {
        return this.adminMessage;
    }

	public void setAdminMessage(String adminMessage) {
        this.adminMessage = adminMessage;
    }


    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", uid=" + uid +
                ", aid=" + aid +
                ", status=" + status +
                ", adminMessage='" + adminMessage + '\'' +
                ", article=" + article +
                ", user=" + user +
                '}';
    }
}