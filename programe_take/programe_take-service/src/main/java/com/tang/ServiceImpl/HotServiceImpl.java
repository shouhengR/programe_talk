package com.tang.ServiceImpl;

import com.tang.Dao.HotDao;
import com.tang.Service.HotService;
import com.tang.bean.Article;
import com.tang.bean.Hot;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-19 21:35
 */
@Service
public class HotServiceImpl implements HotService {

    @Autowired
    public HotDao hotDaoImpl;

    @Override
    public ResultBean addHotArticle(Hot hot) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(hotDaoImpl.addHotArticle(hot).intValue());

        return resultBean;
    }

    @Override
    public ResultBean delHotArticle(Hot hot) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(hotDaoImpl.delHotArticle(hot).intValue());

        return resultBean;
    }

    @Override
    public Long delHotByAid(Integer aid) {
        return hotDaoImpl.delHotByAid(aid);
    }

    @Override
    public PageBean<Hot> selectAll(Integer currentPage, Integer pageSize) {

        PageBean<Hot> pageBean = new PageBean<Hot>();

        Long count = hotDaoImpl.countRecord();
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
        List<Hot> articles = hotDaoImpl.selectAllHotArticle(start);

        pageBean.setList(articles);

//        System.out.println(pageBean);
        return pageBean;

    }
}
