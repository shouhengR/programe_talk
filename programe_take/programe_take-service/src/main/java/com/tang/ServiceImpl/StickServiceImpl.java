package com.tang.ServiceImpl;

import com.tang.Dao.StickDao;
import com.tang.Service.StickService;
import com.tang.bean.Hot;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.Stick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-21 21:15
 */
@Service
public class StickServiceImpl implements StickService {

    @Autowired
    private StickDao stickDaoImpl;

    @Override
    public ResultBean addStickArticle(Stick stick) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(stickDaoImpl.addStickArticle(stick).intValue());

        return resultBean;
    }

    @Override
    public ResultBean delStickArticle(Stick stick) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(stickDaoImpl.delStickArticle(stick).intValue());

        return resultBean;
    }

    @Override
    public PageBean<Stick> selectAll(Integer currentPage, Integer pageSize) {

        PageBean<Stick> pageBean = new PageBean<Stick>();

        Long count = stickDaoImpl.countRecord();
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
        List<Stick> sticks = stickDaoImpl.selectAllStickArticle(start);

        pageBean.setList(sticks);

//        System.out.println(pageBean);
        return pageBean;
    }

    @Override
    public Long delStickByAid(Integer aid) {
        return stickDaoImpl.delStickByAid(aid);
    }
}
