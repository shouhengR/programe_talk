package com.tang.bean;

/**
 * @author Tang
 * @create 2019-01-30 15:29:48
 */
public class Category {

	private Integer id;

	private String name;

	private Integer visitCount;

	private Integer postingCount;

	public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public Integer getVisitCount() {
        return this.visitCount;
    }

	public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

	public Integer getPostingCount() {
        return this.postingCount;
    }

	public void setPostingCount(Integer postingCount) {
        this.postingCount = postingCount;
    }

}