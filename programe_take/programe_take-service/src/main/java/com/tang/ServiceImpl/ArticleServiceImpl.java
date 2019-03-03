package com.tang.ServiceImpl;

import com.tang.Dao.ArticleDao;
import com.tang.Service.ArticleService;
import com.tang.bean.Article;
import com.tang.bean.Comment;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-03 9:47
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Integer addArticle(Article article) {
        return articleDao.addArticle(article);
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public PageBean<Article> selectByPage(Integer currentPage, Integer pageSize,Integer uid) {

        PageBean<Article> pageBean = new PageBean<Article>();

        Long count = articleDao.myCountRecord(uid);
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
        List<Article> articles = articleDao.selectArticleById(uid, start);

        pageBean.setList(articles);

//        System.out.println(pageBean);
        return pageBean;
    }

    @Override
    public Map<Integer, Article> selectArticleByTitle(Integer id, String name) {

        return articleDao.selectArticleByTitle(id,name);
    }

    @Override
    public Integer updateArticle(Integer statusCode, Integer id) {
        return articleDao.updateArticle(statusCode,id);
    }


    @Override
    public Article getArticleDetails(Integer id) {
        return articleDao.getArticleDetails(id);
    }

    @Override
    public PageBean<Article> selectAllByPage(Integer currentPage, Integer pageSize) {

        PageBean<Article> pageBean = new PageBean<Article>();

        Long count = articleDao.countRecord();
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
        List<Article> articles = articleDao.selectAllByPage(start);

        pageBean.setList(articles);


        return pageBean;
    }

    @Override
    public Map<Integer, Article> selectAllByTitle(String title) {
        return articleDao.selectAllByTitle(title);
    }

    @Override
    public ResultBean updateHotArticle(Integer id,Integer hotStatus){

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(articleDao.updateHotArticle(id,hotStatus).intValue());

        return resultBean;
    }

    @Override
    public ResultBean deleteArticleById(Integer[] delArr) {

        ResultBean resultBean = new ResultBean();
        resultBean.setMsg("删除失败!");
        for (int i = 0;i < delArr.length;i++){

            Long flage =  articleDao.deleteArticleById(delArr[i]);

            if (flage.intValue() == 0){

                resultBean.setFlage(0);

                return resultBean;
            }
        }

        resultBean.setFlage(1);
        resultBean.setMsg("删除成功!");

        return resultBean;
    }

    @Override
    public ResultBean updateTopArticle(Integer aid, Integer hotStatus) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(articleDao.updateTopArticle(aid,hotStatus).intValue());

        return resultBean;
    }

    @Override
    public List<Article> selectAll() {
        return articleDao.selectAll();
    }

    @Override
    public PageBean<Article> selectNewArticle(Integer currentPage, Integer pageSize) {

        PageBean<Article> pageBean = new PageBean<Article>();

        Long count = articleDao.countRecord();
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
        List<Article> articles = articleDao.selectNewArticle(start);

        pageBean.setList(articles);


        return pageBean;
    }

    @Override
    public ResultBean addArticlePointNumber(Integer aid) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(articleDao.addArticlePointNumber(aid).intValue());

        return resultBean;
    }

    @Override
    public ResultBean addArticleBrowseNumber(Integer aid) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(articleDao.addArticleBrowseNumber(aid).intValue());

        return resultBean;
    }

    @Override
    public ResultBean addArticleCommentNumber(Integer aid) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(articleDao.addArticleCommentNumber(aid).intValue());

        return resultBean;
    }

    @Override
    public List<Article> selectByCategoryId(Integer cid) {

        List<Article> articles = articleDao.selectByCategoryId(cid);

        return articles;
    }

    @Override
    public Map<Integer, Article> selectAllByTitleNav(String title) {
        return articleDao.selectAllByTitleNav(title);
    }

    @Override
    public ResultBean reduceArticleCommentNumber(Integer aid) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(articleDao.reduceArticleCommentNumber(aid));

        resultBean.setMsg("评论数减一成功!");

        return resultBean;
    }

    @Override
    public List<Article> selectBrowserNumberMax() {
        return articleDao.selectBrowserNumberMax();
    }

    @Override
    public List<Article> selectArticleByUid(Integer uid) {
        return articleDao.selectArticleByUid(uid);
    }

    @Override
    public Article adminArticleDetails(Integer aid) {
        return articleDao.adminArticleDetails(aid);
    }

}
