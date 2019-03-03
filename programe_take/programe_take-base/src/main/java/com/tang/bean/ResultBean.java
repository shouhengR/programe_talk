package com.tang.bean;

/**
 * @author ASUS
 * @create 2019-02-02 10:10
 */
public class ResultBean {

//    消息
    private String msg;
    private Integer flage;
    private String page;

    public ResultBean(){}

    public ResultBean(String msg, Integer flage, String page) {
        this.msg = msg;
        this.flage = flage;
        this.page = page;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getFlage() {
        return flage;
    }

    public void setFlage(Integer flage) {
        this.flage = flage;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
