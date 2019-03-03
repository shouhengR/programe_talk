package com.tang.bean;

import java.util.Date;

/**
 * @author Tang
 * @create 2019-01-30 15:29:48
 */
public class Hot {

	private Integer id;

	private Integer aid;

	private Integer uid;

	private Date time;

	private Article article;

	private User user;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

	public Integer getAid() {
        return this.aid;
    }

	public void setAid(Integer aid) {
        this.aid = aid;
    }

	public Integer getUid() {
        return this.uid;
    }

	public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Hot{" +
                "id=" + id +
                ", aid=" + aid +
                ", uid=" + uid +
                '}';
    }
}