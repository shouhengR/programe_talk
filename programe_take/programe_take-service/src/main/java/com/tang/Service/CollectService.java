package com.tang.Service;

import com.tang.bean.Collect;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;

/**
 * @author ASUS
 * @create 2019-02-15 14:58
 */
public interface CollectService {

    public PageBean<Collect> selectAllByUserId(Integer currentPage, Integer pageSize,Integer uid);

    public Integer deleteCollect(Integer cid);

    public ResultBean addCollect(Collect collect);

    public Long checkRepeatCollect(Integer uid,Integer aid);

    public Long delCollectByAid(Integer aid);

}
