package com.tang.bean;

/**
 * @author Tang
 * @create 2019-01-30 15:29:48
 */
public class Collect{

	private Integer id;

	private Integer aid;

	private Integer uid;

	private java.util.Date time;

	private User user;

	private Article article;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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

	public java.util.Date getTime() {
        return this.time;
    }

	public void setTime(java.util.Date time) {
        this.time = time;
    }

}