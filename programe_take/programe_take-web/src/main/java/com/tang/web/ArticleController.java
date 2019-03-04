package com.tang.web;

import com.tang.Service.*;
import com.tang.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-03 9:48
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private AuditService auditServiceImpl;

    @Autowired
    private CollectService collectServiceImpl;

    @Autowired
    private CommentService commentServiceImpl;

    @Autowired
    private HotService hotServiceImpl;

    @Autowired
    private StickService stickServiceImpl;

    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/article/{id}")
    @ResponseBody
    public Article getArticleById(@PathVariable("id") Integer id) {
        return articleServiceImpl.getArticleById(id);
    }

    //    文章添加
    @PostMapping("/article/add")
    @ResponseBody
    public ResultBean addArticle(Article article, HttpSession session) {

        ResultBean resultBean = new ResultBean();

        User user = (User) session.getAttribute("user");

        if (user == null) {

            resultBean.setFlage(0);

            resultBean.setMsg("请先去登陆!");

            return resultBean;
        }

        article.setCreatetime(new Date());
        article.setCommentNumber(0);
        article.setBrowseNumber(0);
        article.setPointsNumber(0);
        article.setHotStatus(0);
        article.setTopStatus(0);
        article.setStatus(0);

//        设置文章拥有者
        article.setUid(user.getId());
//         添加文章
        Integer flage = articleServiceImpl.addArticle(article);

        Audit audit = new Audit();
        audit.setAdminMessage("");
        audit.setAid(article.getId());
        audit.setStatus(0);
        audit.setUid(user.getId());
        audit.setAuditTime(new Date());
//         添加审核记录
        auditServiceImpl.addAudit(audit);

        resultBean.setFlage(flage);

        return resultBean;
    }

    //  所有文章
    @GetMapping("/article/all")
    @ResponseBody
    public List<Article> selectAll() {
        return articleServiceImpl.selectAll();
    }

    // 首页 ---> 最新
    @GetMapping("/article/new/all")
    @ResponseBody
    public PageBean<Article> selectNewArticleByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                                    @RequestParam(defaultValue = "5") Integer pageSize) {

        System.out.println(currentPage + "\t" + pageSize);

        return articleServiceImpl.selectNewArticle(currentPage, pageSize);
    }

    //    用户管理-我的文章
    @GetMapping("/user/myarticle")
    @ResponseBody
    public PageBean<Article> selectAllByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                             @RequestParam(defaultValue = "5") Integer pageSize, HttpSession session) {

        System.out.println(currentPage + "\t" + pageSize);

        User user = (User) session.getAttribute("user");

        return articleServiceImpl.selectByPage(currentPage, pageSize, user.getId());
    }

    //    admin管理-文章管理
    @GetMapping("/admin/articles")
    @ResponseBody
    public PageBean<Article> selectAllByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                             @RequestParam(defaultValue = "5") Integer pageSize) {

        System.out.println(currentPage + "\t" + pageSize);

        return articleServiceImpl.selectAllByPage(currentPage, pageSize);
    }

    //  admin管理-文章管理-文章搜索
    @GetMapping("/admin/article/search")
    @ResponseBody
    public Map<Integer, Article> selectAllByTitle(String title) {

        return articleServiceImpl.selectAllByTitle(title);

    }

    //    导航栏上的文章搜索
    @GetMapping("/nav/article/search")
    @ResponseBody
    public Map<Integer, Article> selectAllByTitleNav(String title) {

        return articleServiceImpl.selectAllByTitleNav(title);

    }

    //    搜索页面---->页面渲染
    @GetMapping("/search/result")
    public String selectAllByTitle(String title, ModelMap modelMap) {

//        System.out.println("要搜索的内容:"+title);

        Map<Integer, Article> map = articleServiceImpl.selectAllByTitleNav(title);

//        System.out.println(map.size());
//
//        for (Map.Entry<Integer,Article> item : map.entrySet()){
//            System.out.println(map.get(item.getKey()));
//        }

        modelMap.addAttribute("resultMap", map.values());

        return "search_Result";
    }

    //  admin管理-文章管理-推荐热门
    @PostMapping("/article/hot/update")
    @ResponseBody
    public ResultBean updateHotArticle(Integer aid, Integer hotStatus) {
        System.out.println(aid);
        return articleServiceImpl.updateHotArticle(aid, hotStatus);
    }

    //  admin管理-文章管理-文章置顶
    @PostMapping("/article/top/update")
    @ResponseBody
    public ResultBean updateTopArticle(Integer aid, Integer topStatus) {
        System.out.println(aid);
        return articleServiceImpl.updateTopArticle(aid, topStatus);
    }

    //  admin管理-文章管理-文章删除
    @DeleteMapping("/article/del")
    @ResponseBody
    public ResultBean delArticle(Integer[] delArr) {

        System.out.println(Arrays.toString(delArr));

        for (Integer id : delArr) {

//        1.删除 审核表中的 审核记录
            Long aLong = auditServiceImpl.delAuditByAid(id);
            System.out.println(aLong);
//        2.删除 收藏表中的 文章记录
            Long bLong = collectServiceImpl.delCollectByAid(id);
            System.out.println(bLong);
//        3.删除 热门推荐的 推荐记录
            Long cLong = hotServiceImpl.delHotByAid(id);
            System.out.println(cLong);
//        4.删除 好文置顶的 置顶记录
            Long dLong = stickServiceImpl.delStickByAid(id);
            System.out.println(dLong);
//        5.删除 文章下面的评论
            Long eLong = commentServiceImpl.delCommentByAid(id);
            System.out.println(eLong);
        }
        //        6.删除此文章
        return articleServiceImpl.deleteArticleById(delArr);
    }

    //    user管理  --- 删除文章
    @DeleteMapping("/user/del/article")
    @ResponseBody
    public ResultBean userDelArticleById(Integer id) {

//        1.删除 审核表中的 审核记录
        Long aLong = auditServiceImpl.delAuditByAid(id);
//        System.out.println(aLong);
//        2.删除 收藏表中的 文章记录
        Long bLong = collectServiceImpl.delCollectByAid(id);
//        System.out.println(bLong);
//        3.删除 热门推荐的 推荐记录
        Long cLong = hotServiceImpl.delHotByAid(id);
//        System.out.println(cLong);
//        4.删除 好文置顶的 置顶记录
        Long dLong = stickServiceImpl.delStickByAid(id);
//        System.out.println(dLong);
//        5.删除 文章下面的评论
        Long eLong = commentServiceImpl.delCommentByAid(id);
//        System.out.println(eLong);

//        6.删除此文章
        ResultBean resultBean = articleServiceImpl.deleteArticleById(new Integer[]{id});

        return resultBean;
    }

    //  用户管理-我的文章-文章搜索
    @GetMapping("/user/myarticle/search")
    @ResponseBody
    public Map<Integer, Article> selectArticleByTitle(String title, HttpSession session) {

        User user = (User) session.getAttribute("user");

        return articleServiceImpl.selectArticleByTitle(user.getId(), title);

    }

    //    文章点赞数
    @GetMapping("/article/pointNumber/{aid}")
    @ResponseBody
    public ResultBean addArticlePointNumber(@PathVariable("aid") Integer aid) {

        return articleServiceImpl.addArticlePointNumber(aid);
    }

    //   文章浏览数
    @GetMapping("/article/browseNumber/{aid}")
    @ResponseBody
    public ResultBean addArticleBrowseNumber(@PathVariable("aid") Integer aid) {
        return articleServiceImpl.addArticleBrowseNumber(aid);
    }

    //    文章评论数+1
    @GetMapping("/article/commentNumber/{aid}")
    @ResponseBody
    public ResultBean addArticleCommentNumber(@PathVariable("aid") Integer aid) {

        return articleServiceImpl.addArticleCommentNumber(aid);
    }

    //    文章评论数减一
    @GetMapping("/article/commentNumber/reduce/{aid}")
    @ResponseBody
    public ResultBean reduceArticleCommentNumber(@PathVariable("aid") Integer aid) {
        return articleServiceImpl.reduceArticleCommentNumber(aid);
    }

    //    admin --> 文章管理 --> 文章详情
    @GetMapping("/admin/article/details")
    public String adminArticleDetails(Integer aid, ModelMap modelMap) {

//        文章浏览量+1
        articleServiceImpl.addArticleBrowseNumber(aid);
//        admin 版 获取文章信息
        Article article = articleServiceImpl.adminArticleDetails(aid);
//        获取文章下面的评论信息
        List<Comment> commentList = commentServiceImpl.selectCommentByArticleId(aid);
//        获取最新的评论
        List<Comment> newComment = commentServiceImpl.selectNewComment(aid);

//        文章种类的拜访量+1
        modelMap.addAttribute("article", article);

        modelMap.addAttribute("commentList", commentList);

        modelMap.addAttribute("newComment", newComment);

        return "article_details";
    }


    //    通过文章id 查询文章 返回文章详细信息  返回评论信息
    @GetMapping("/user/article/details")
    public String articleDetails(Integer aid, ModelMap modelMap) {

//        文章浏览量+1
        articleServiceImpl.addArticleBrowseNumber(aid);
//        获取文章信息
        Article article = articleServiceImpl.getArticleDetails(aid);
//        获取文章下面的评论信息
        List<Comment> commentList = commentServiceImpl.selectCommentByArticleId(aid);
//        获取最新的评论
        List<Comment> newComment = commentServiceImpl.selectNewComment(aid);

//        文章种类的拜访量+1
        modelMap.addAttribute("article", article);

        modelMap.addAttribute("commentList", commentList);

        modelMap.addAttribute("newComment", newComment);

        return "article_details.html";
    }

    //    前端开发页面
    @GetMapping("/article/category/{cid}")
    @ResponseBody
    public List<Article> selectByCategoryId(@PathVariable("cid") Integer cid) {

        return articleServiceImpl.selectByCategoryId(cid);

    }

    @GetMapping("/article/category/{cid}/{title}")
    @ResponseBody
    public List<Article> selectByCategoryIdAndTitle(@PathVariable("cid") Integer cid,
                                                    @PathVariable("title") String title) {

        return articleServiceImpl.selectByCategoryIdAndTitle(cid,title);

    }

    //  统计 最热门的文章
    @GetMapping("/article/sum/hot")
    @ResponseBody
    public List<Article> selectBrowserNumberMax() {
        return articleServiceImpl.selectBrowserNumberMax();
    }

    //  self 界面  用户介绍界面
    @GetMapping("/article/user/info/{uid}")
    public String selectArticleByUid(@PathVariable("uid") Integer uid, ModelMap modelMap) {

//        拿到当前用户的 所有发表的文章信息
        List<Article> articles = articleServiceImpl.selectArticleByUid(uid);

        modelMap.addAttribute("articles", articles);
//      用户信息
        modelMap.addAttribute("user", articles.get(0).getUser());

        return "user_self";
    }

}
