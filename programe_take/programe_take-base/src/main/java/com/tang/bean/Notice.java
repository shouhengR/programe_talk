package com.tang.bean;

/**
 * @author ASUS
 * @create 2019-02-27 17:57
 */
public class Notice {

    private Integer id;
    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
