package com.tang.bean;

/**
 * @author Tang
 * @create 2019-01-30 15:29:48
 */
public class Concerns {

	private Integer id;

	private Integer auid;

	private Integer buid;

	private User aUser;

	private User bUser;

    public User getaUser() {
        return aUser;
    }

    public void setaUser(User aUser) {
        this.aUser = aUser;
    }

    public User getbUser() {
        return bUser;
    }

    public void setbUser(User bUser) {
        this.bUser = bUser;
    }

    public Integer getId() {
        return this.id;
    }

	public void setId(Integer id) {
        this.id = id;
    }

	public Integer getAuid() {
        return this.auid;
    }

	public void setAuid(Integer auid) {
        this.auid = auid;
    }

	public Integer getBuid() {
        return this.buid;
    }

	public void setBuid(Integer buid) {
        this.buid = buid;
    }

}