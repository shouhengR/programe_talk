package com.tang.bean;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-06 22:57
 */
public class PageBean <T> {
//    总记录数
    private Integer recordCount;
//    总页数
    private Integer countPage;
//    每页的大小
    private Integer pageSize;
//    当前页
    private Integer currentPage;
//    结果集
    private List<T> list;

    public PageBean(){}

    public PageBean(Integer recordCount, Integer countPage, Integer pageSize, Integer currentPage) {
        this.recordCount = recordCount;
        this.countPage = countPage;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "recordCount=" + recordCount +
                ", countPage=" + countPage +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", list=" + list +
                '}';
    }
}
