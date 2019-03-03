package com.tang.Service;

import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.Stick;

/**
 * @author ASUS
 * @create 2019-02-21 21:13
 */
public interface StickService {

    public ResultBean addStickArticle(Stick stick);

    public ResultBean delStickArticle(Stick stick);

    public PageBean<Stick> selectAll(Integer currentPage, Integer pageSize);

    public  Long delStickByAid(Integer aid);

}
