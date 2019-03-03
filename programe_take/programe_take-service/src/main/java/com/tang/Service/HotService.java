package com.tang.Service;

import com.tang.bean.Hot;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;

/**
 * @author ASUS
 * @create 2019-02-19 21:34
 */
public interface HotService {

    public ResultBean addHotArticle(Hot hot);

    public ResultBean delHotArticle(Hot hot);

    public Long delHotByAid(Integer aid);


    public PageBean<Hot> selectAll(Integer currentPage, Integer pageSize);

}
