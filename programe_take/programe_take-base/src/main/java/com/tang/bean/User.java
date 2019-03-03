package com.tang.bean;

/**
 * @author Tang
 * @create 2019-01-30 15:29:48
 */
public class User {

	private Integer id;

	private String username;

	private String password;

	private Integer age;

	private String sex;

	private String phone;

	private String headerImg;

	private Integer articleCount;

	private java.util.Date jointime;

	private String desc;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

	public String getPassword() {
        return this.password;
    }

	public void setPassword(String password) {
        this.password = password;
    }

	public Integer getAge() {
        return this.age;
    }

	public void setAge(Integer age) {
        this.age = age;
    }

	public String getSex() {
        return this.sex;
    }

	public void setSex(String sex) {
        this.sex = sex;
    }

	public String getPhone() {
        return this.phone;
    }

	public void setPhone(String phone) {
        this.phone = phone;
    }

	public String getHeaderImg() {
        return this.headerImg;
    }

	public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

	public Integer getArticleCount() {
        return this.articleCount;
    }

	public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

	public java.util.Date getJointime() {
        return this.jointime;
    }

	public void setJointime(java.util.Date jointime) {
        this.jointime = jointime;
    }

	public String getDesc() {
        return this.desc;
    }

	public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", headerImg='" + headerImg + '\'' +
                ", articleCount=" + articleCount +
                ", jointime=" + jointime +
                ", desc='" + desc + '\'' +
                '}';
    }
}