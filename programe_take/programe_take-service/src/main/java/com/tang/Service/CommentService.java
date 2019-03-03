package com.tang.Service;

import com.tang.bean.Comment;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-24 9:29
 */
public interface CommentService {

    public ResultBean addComment(Comment comment);

    public ResultBean deleteCommentById(Integer[] delArr);

    public List<Comment> selectCommentByArticleId(Integer aid);

    public List<Comment> selectNewComment(Integer aid);

    public ResultBean repeatComment(Comment comment);

    public List<Comment> selectUserComment(Integer uid);

    public String selectRepeatContent(Integer id);

    public ResultBean updateCancelNewFlage(Integer id);

    public PageBean<Comment> selectAllAdminComment(Integer currentPage, Integer pageSize);

    public ResultBean delComment(Integer id);

    public Long delCommentByAid(Integer id);
}
