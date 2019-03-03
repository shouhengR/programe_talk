package com.tang.ServiceImpl;

import com.tang.Dao.CommentDao;
import com.tang.Service.CommentService;
import com.tang.bean.Article;
import com.tang.bean.Comment;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-24 9:30
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDaoImpl;

    @Override
    public ResultBean addComment(Comment comment) {

        ResultBean resultBean = new ResultBean();

        resultBean.setMsg("发表失败!");

        resultBean.setFlage(commentDaoImpl.addComment(comment));

        if (resultBean.getFlage() == 1){
            resultBean.setMsg("发表成功!");
        }

        return resultBean;
    }

    public ResultBean deleteCommentById(Integer[] delArr){

        ResultBean resultBean = new ResultBean();

        for (int i = 0;i < delArr.length;i++){

            Integer flage =  commentDaoImpl.delComment(delArr[i]);

            if (flage == 0){

                resultBean.setFlage(0);

                return resultBean;
            }
        }
        resultBean.setFlage(1);

        return resultBean;
    }

    @Override
    public List<Comment> selectCommentByArticleId(Integer aid) {

        return commentDaoImpl.selectCommentByArticleId(aid);
    }

    @Override
    public List<Comment> selectNewComment(Integer aid) {
        return commentDaoImpl.selectNewComment(aid);
    }

    @Override
    public ResultBean repeatComment(Comment comment) {
//        要回复记录的id
        Integer id = comment.getId();

        comment.setId(null);

        ResultBean resultBean = new ResultBean();

        resultBean.setMsg("回复失败!");
        resultBean.setFlage(commentDaoImpl.repeatComment(comment).intValue());
//        回复记录过后新插入条数的id
        Integer newId = comment.getId();

        System.out.println("插入的新纪录:"+comment);

        if (resultBean.getFlage() == 1){

            System.out.println();

            commentDaoImpl.updateRepeatId(id,newId);

            resultBean.setMsg("回复成功!");
        }

        return resultBean;

    }

    @Override
    public List<Comment> selectUserComment(Integer uid) {

        List<Comment> comments = commentDaoImpl.selectUserComment(uid);

        List<Comment> repeats = commentDaoImpl.selectUserRepeat(uid);

        repeats.addAll(comments);

        return repeats;

    }

    @Override
    public String selectRepeatContent(Integer id) {
        return commentDaoImpl.selectRepeatContent(id);
    }

    @Override
    public ResultBean updateCancelNewFlage(Integer id) {

        ResultBean resultBean = new ResultBean();

        resultBean.setMsg("标记失败!");

        resultBean.setFlage(commentDaoImpl.updateCancelNewFlage(id));

        if (resultBean.getFlage() == 1){
            resultBean.setMsg("标记更新成功!");
        }

        return resultBean;

    }

    @Override
    public ResultBean delComment(Integer id) {

        ResultBean resultBean = new ResultBean();

        resultBean.setMsg("删除失败!");

        resultBean.setFlage(commentDaoImpl.delComment(id));

        if (resultBean.getFlage() == 1){
            resultBean.setMsg("删除成功!");
        }

        return resultBean;
    }

    @Override
    public Long delCommentByAid(Integer id) {
        return commentDaoImpl.delCommentByAid(id);
    }

    @Override
    public PageBean<Comment> selectAllAdminComment(Integer currentPage, Integer pageSize) {

        PageBean<Comment> pageBean = new PageBean<>();

        Long count = commentDaoImpl.countRecord();
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

        System.out.println(start);
//        分页查询
        List<Comment> comments = commentDaoImpl.selectAllAdminComment(start);

        pageBean.setList(comments);

        return pageBean;
    }
}
