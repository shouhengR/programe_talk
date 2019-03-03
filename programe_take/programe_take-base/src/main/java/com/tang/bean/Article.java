package com.tang.bean;

/**
 * @author Tang
 * @create 2019-01-30 15:29:48
 */
public class Article {

	private Integer id;

	private String title;

	private String content;
//  评论数
	private Integer commentNumber;
//  点赞数
	private Integer pointsNumber;
//  浏览量
	private Integer browseNumber;

	private java.util.Date createtime;
//  审核状态 默认0 在审核
	private Integer status;
//	是否置顶 0 (默认)不置顶 1置顶
    private Integer topStatus;
//  是否是热门的一个标识 0 不是  1 是
	private Integer hotStatus;
//     用户id
	private Integer uid;
//    类别
	private Integer cid;
//	 类别
	private Category category;
//	所属用户
	private User user;

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Integer getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(Integer topStatus) {
        this.topStatus = topStatus;
    }

    public Integer getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(Integer hotStatus) {
        this.hotStatus = hotStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

	public String getTitle() {
        return this.title;
    }

	public void setTitle(String title) {
        this.title = title;
    }

	public String getContent() {
        return this.content;
    }

	public void setContent(String content) {
        this.content = content;
    }

	public Integer getPointsNumber() {
        return this.pointsNumber;
    }

	public void setPointsNumber(Integer pointsNumber) {
        this.pointsNumber = pointsNumber;
    }

	public Integer getBrowseNumber() {
        return this.browseNumber;
    }

	public void setBrowseNumber(Integer browseNumber) {
        this.browseNumber = browseNumber;
    }

	public java.util.Date getCreatetime() {
        return this.createtime;
    }

	public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

	public Integer getUid() {
        return this.uid;
    }

	public void setUid(Integer uid) {
        this.uid = uid;
    }

	public Integer getCid() {
        return this.cid;
    }

	public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", commentNumber=" + commentNumber +
                ", pointsNumber=" + pointsNumber +
                ", browseNumber=" + browseNumber +
                ", createtime=" + createtime +
                ", status=" + status +
                ", topStatus=" + topStatus +
                ", hotStatus=" + hotStatus +
                ", uid=" + uid +
                ", cid=" + cid +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}