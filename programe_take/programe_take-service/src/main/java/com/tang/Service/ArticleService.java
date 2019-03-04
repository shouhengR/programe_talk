package com.tang.Service;

import com.tang.bean.Article;
import com.tang.bean.Comment;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-03 9:47
 */
public interface ArticleService {
//     添加文章
    public Integer addArticle(Article article);

    public Article getArticleById(Integer id);

//    分页查询
    public PageBean<Article> selectByPage(Integer currentPage, Integer pageSize, Integer uid);
//    用户名查询
    public Map<Integer,Article> selectArticleByTitle(Integer id, String name);

    public Integer updateArticle(Integer statusCode, Integer id);

    public Article getArticleDetails(Integer id);
// 查询所有文章
    public PageBean<Article> selectAllByPage(Integer currentPage, Integer pageSize);
//    根据文章title 查询文章
    public Map<Integer,Article> selectAllByTitle(String title);

    public ResultBean updateHotArticle(Integer id,Integer hotStatus);

    public ResultBean deleteArticleById(Integer[] delArr);

    public ResultBean updateTopArticle(Integer aid, Integer hotStatus);

    public List<Article> selectAll();

    public PageBean<Article> selectNewArticle(Integer currentPage, Integer pageSize);

    public ResultBean addArticlePointNumber(Integer aid);

    public ResultBean addArticleBrowseNumber(Integer aid);

    public ResultBean addArticleCommentNumber(Integer aid);

    public List<Article> selectByCategoryId(Integer cid);

    public Map<Integer,Article> selectAllByTitleNav(String title);

    public ResultBean reduceArticleCommentNumber(Integer aid);

    public List<Article> selectBrowserNumberMax();

    public List<Article> selectArticleByUid(Integer uid);

    public Article adminArticleDetails(Integer aid);

    public List<Article> selectByCategoryIdAndTitle(Integer cid, String title);
}
