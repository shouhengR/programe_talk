package com.tang.Dao;

import com.tang.bean.Article;
import com.tang.bean.Comment;
import com.tang.bean.Hot;
import com.tang.bean.ResultBean;
import org.apache.ibatis.annotations.*;
import sun.text.normalizer.UBiDiProps;

import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-03 9:46
 */
@Mapper
public interface ArticleDao {

//    通过id 返回文章
    @Select("select * from article where id = #{id}")
    public Article getArticleById(Integer id);

//   文章添加
    public Integer addArticle(Article article);

//   分页查询
    public List<Article> selectArticleById(@Param("id") Integer id,@Param("start") Integer start);
//    主页--->最新文章
    public List<Article> selectNewArticle(Integer start);

//   总记录数
    @Select("select count(*) from article where status = 1")
    public Long countRecord();

//   删除文章
    @Delete("delete from article where id = #{id}")
    public Long deleteArticleById(Integer id);

//    通过用户名执行查询                                            用户id                         文章标题
    @MapKey("cid")
    public Map<Integer,Article> selectArticleByTitle(@Param("id") Integer id,@Param("name") String name);

//    更新文章 审核状态
    @Update("update article set status = #{statusCode} where id = #{id}")
    public Integer updateArticle(@Param("statusCode") Integer statusCode,@Param("id") Integer id);

//    返回文章信息                文章id
    public Article getArticleDetails(Integer aid);

    // admin版获取文章信息 文章在审核中
    public Article adminArticleDetails(Integer aid);

//  指定用户的文章数
    @Select("select count(*) from article where uid = #{id} and status = 1")
    public Long myCountRecord(Integer uid);

//  admin 文章管理  查询所有文章
    public List<Article> selectAllByPage(Integer start);

//  主页 综合区
    public List<Article> selectAll();

    //  admin 文章管理 文章搜索
    @MapKey("cid")
    public Map<Integer,Article> selectAllByTitle(@Param("title") String title);

//    admin 文章管理 推荐为热门文章
    @Update("update article set hotStatus = #{hotStatus} where id = #{id}")
    public Long updateHotArticle(@Param("id") Integer id,@Param("hotStatus") Integer hotStatus);

//    admin 文章管理 文章置顶
    @Update("update article set topStatus = #{topStatus} where id = #{id}")
    public Long updateTopArticle(@Param("id") Integer id,@Param("topStatus") Integer topStatus);
//    文章点赞数增加
    @Update("update article set pointsNumber = pointsNumber + 1 where id = #{aid}")
    public Long addArticlePointNumber(Integer aid);
//    文章浏览量增加
    @Update("update article set browseNumber = browseNumber + 1 where id = #{aid}")
    public Long addArticleBrowseNumber(Integer aid);

//    文章评论数数增加
    @Update("update article set commentNumber = commentNumber + 1 where id = #{aid}")
    public Long addArticleCommentNumber(Integer aid);

    //    文章的评论数减一
    @Update("update article set commentNumber = commentNumber - 1 where id = #{aid}")
    public Integer reduceArticleCommentNumber(Integer aid);

//   前端开发页面的数据源---》 根据类型进行查询
    public List<Article> selectByCategoryId(Integer cid);

    @MapKey("id")
    public Map<Integer,Article> selectAllByTitleNav(@Param("title") String title);

//    网站统计  统计访问量最高的文章 5篇
    @Select("select * from article ORDER BY browseNumber desc LIMIT 0,9")
    public List<Article> selectBrowserNumberMax();

    //    用户信息介绍页面
    public List<Article> selectArticleByUid(Integer uid);

}