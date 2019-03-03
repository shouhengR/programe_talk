package com.tang.bean;

/**
 * @author Tang
 * @create 2019-01-30 15:29:48
 */
public class Comment {

	private Integer id;

	private Integer uaid;

	private String acontent;

	private Integer ubid;

	private String bcontent;

	private java.util.Date time;

	private Integer aid;

	private Integer status;

	private Integer repeatId;

	private Article article;

	private User auser;

    private User buser;

    public Integer getRepeatId() {
        return repeatId;
    }

    public void setRepeatId(Integer repeatId) {
        this.repeatId = repeatId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getAuser() {
        return auser;
    }

    public void setAuser(User auser) {
        this.auser = auser;
    }

    public User getBuser() {
        return buser;
    }

    public void setBuser(User buser) {
        this.buser = buser;
    }

    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

	public Integer getUaid() {
        return this.uaid;
    }

	public void setUaid(Integer uaid) {
        this.uaid = uaid;
    }

	public String getAcontent() {
        return this.acontent;
    }

	public void setAcontent(String acontent) {
        this.acontent = acontent;
    }

	public Integer getUbid() {
        return this.ubid;
    }

	public void setUbid(Integer ubid) {
        this.ubid = ubid;
    }

	public String getBcontent() {
        return this.bcontent;
    }

	public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

	public java.util.Date getTime() {
        return this.time;
    }

	public void setTime(java.util.Date time) {
        this.time = time;
    }

	public Integer getAid() {
        return this.aid;
    }

	public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", uaid=" + uaid +
                ", acontent='" + acontent + '\'' +
                ", ubid=" + ubid +
                ", bcontent='" + bcontent + '\'' +
                ", time=" + time +
                ", aid=" + aid +
                ", article=" + article +
                ", auser=" + auser +
                ", buser=" + buser +
                '}';
    }
}