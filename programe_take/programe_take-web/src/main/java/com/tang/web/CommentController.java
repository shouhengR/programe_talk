package com.tang.web;

import com.tang.Service.ArticleService;
import com.tang.Service.CommentService;
import com.tang.bean.*;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-24 9:44
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleServiceImpl;

    //    文章详情  -->添加评论
    @PostMapping("/comment/add")
    @ResponseBody
    public ResultBean addComment(Comment comment, HttpSession session) {

        User user = (User) session.getAttribute("user");

        comment.setUaid(user.getId());
        comment.setTime(new Date());
        comment.setBcontent(null);
//        0为  未查看的回复  1为  已查看的回复
        comment.setStatus(0);

        System.out.println(comment);

        ResultBean resultBean = commentService.addComment(comment);

        if (resultBean.getFlage() == 1) {
//            增加文章评论数
            articleServiceImpl.addArticleCommentNumber(comment.getAid());
        }

        return resultBean;
    }


    @DeleteMapping("/comment/del")
    @ResponseBody
    public ResultBean deleteCommentById(Integer[] delArr){

        System.out.println(Arrays.toString(delArr));

        return commentService.deleteCommentById(delArr);
    }


    //    文章详情  -->评论回复
    @PostMapping("/comment/repeat")
    @ResponseBody
    public ResultBean repeatComment(Comment comment, HttpSession session) {

        User user = (User) session.getAttribute("user");

        comment.setUbid(user.getId());
        comment.setTime(new Date());
        comment.setStatus(0);
//        原先的记录
        System.out.println(comment);

        ResultBean resultBean = commentService.repeatComment(comment);

        if (resultBean.getFlage() == 1) {
//            增加文章评论数
            articleServiceImpl.addArticleCommentNumber(comment.getAid());
        }

        return resultBean;
    }

    //  user--->我的回复----》加载属于当前用户的所有回复
    @GetMapping("/user/comments")
    @ResponseBody
    public List<Comment> selectUserComment(HttpSession session) {

        User user = (User) session.getAttribute("user");

        return commentService.selectUserComment(user.getId());
    }

    //  user--->我的回复----》返回指定记录的回复内容
    @GetMapping("/user/repeat/content")
    @ResponseBody
    public String selectRepeatContent(Integer id) {
        return commentService.selectRepeatContent(id);
    }

    //  user--->我的回复----》取消最热的标记
    @GetMapping("/user/repeat/cancel")
    @ResponseBody
    public ResultBean updateCancelNewFlage(Integer id) {
        return commentService.updateCancelNewFlage(id);
    }

    //  user--->我的回复----》回复删除
    @DeleteMapping("/user/repeat/delete")
    @ResponseBody
    public ResultBean delComment(Integer id) {
        return commentService.delComment(id);
    }

    //  admin--->评论管理
    @GetMapping("/admin/comments")
    @ResponseBody
    public PageBean<Comment> selectAllAdminComment(@RequestParam(defaultValue = "1") Integer currentPage,
                                                   @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println("currentPage--->"+currentPage+" pageSize--->"+pageSize);
        return commentService.selectAllAdminComment(currentPage, pageSize);

    }

}
