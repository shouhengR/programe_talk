package com.tang.ServiceImpl;

import com.tang.Dao.CollectDao;
import com.tang.Service.CollectService;
import com.tang.bean.Collect;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-15 15:00
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;

    @Override
    public PageBean<Collect> selectAllByUserId(Integer currentPage, Integer pageSize,Integer uid) {

        PageBean<Collect> pageBean = new PageBean<>();

        Long count = collectDao.countRecord();
//        设置总记录数
        pageBean.setRecordCount(count.intValue());
//        每页的大小
        pageBean.setPageSize(pageSize);
//        总页数
        Integer countPage = (count.intValue() + pageSize - 1) / pageSize;

        pageBean.setCountPage(countPage);

        if (countPage != 0){
            if (currentPage > countPage){
                currentPage = countPage;
            }
        }
//        当前页
        pageBean.setCurrentPage(currentPage);

        Integer start = (currentPage - 1) * pageSize;
//        分页查询
        List<Collect> collects = collectDao.selectAllByUserId(uid, start);

        pageBean.setList(collects);

        return pageBean;
    }

    @Override
    public Integer deleteCollect(Integer cid) {
        return collectDao.deleteCollect(cid);
    }

    @Override
    public ResultBean addCollect(Collect collect) {

        ResultBean resultBean = new ResultBean();

        Integer flage = collectDao.addCollect(collect);

        if (flage == 1){
            resultBean.setMsg("收藏成功!可在'我的收藏'中查看!");
        }else {
            resultBean.setMsg("收藏失败!错误未知!");
        }
        resultBean.setFlage(flage);

        return resultBean;
    }

    @Override
    public Long checkRepeatCollect(Integer uid, Integer aid) {
        return collectDao.checkRepeatCollect(uid,aid);
    }

    @Override
    public Long delCollectByAid(Integer aid) {
        return collectDao.delCollectByAid(aid);
    }
}
