package com.tang.Dao;

import com.tang.bean.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-24 9:14
 */
@Mapper
public interface CommentDao {
//    添加评论
    @Insert("insert into comment values(null,#{uaid},#{acontent},#{ubid},#{bcontent},#{time},#{aid},#{status},#{repeatId})")
    public Integer addComment(Comment comment);
//    删除评论
    @Delete("delete from comment where id = #{id}")
    public Integer delComment(Integer id);

//    查询回复内容
    @Select("select bcontent from comment where id = #{id}")
    public String selectRepeatContent(Integer id);

//    查询指定文章下的评论                                   文章id
    public List<Comment> selectCommentByArticleId(Integer aid);
//    最新评论查询
    public List<Comment> selectNewComment(Integer aid);
//    评论回复
    public Long repeatComment(Comment comment);

//    user ---> 我的回复 --->  用户评论我的文章
    public List<Comment> selectUserComment(Integer ubid);

//    user ---> 我的回复 --->  用户回复我
    public List<Comment> selectUserRepeat(Integer uaid);

//    user--->我的回复--->设置回复记录的id            要更新的记录id   回复记录的id
    @Update("update comment set repeatId = #{repeatId} where id = #{id}")
    public void updateRepeatId(@Param("id") Integer id,@Param("repeatId") Integer repeatId);

//    user--->我的回复--->取消最新的标记
    @Update("update comment set status = 1 where id = #{id}")
    public Integer updateCancelNewFlage(Integer id);

    @Select("select count(*) from comment where uaid = #{uaid} and status = 0")
    public Long myCountRecord(Integer uaid);

//    admin ---> 评论管理
    public List<Comment> selectAllAdminComment(Integer start);

    @Select("SELECT count(*) from `comment` c where " +
            "c.id not in (SELECT repeatId FROM `comment` WHERE not ISNULL(repeatId))")
    public Long countRecord();

//  删除文章的下面的所有评论的
    @Delete("delete from comment where aid = #{aid}")
    public Long delCommentByAid(Integer aid);
}
