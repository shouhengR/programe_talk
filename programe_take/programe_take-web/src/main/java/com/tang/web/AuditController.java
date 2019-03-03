package com.tang.web;

import com.tang.Dao.UserDao;
import com.tang.Service.ArticleService;
import com.tang.Service.AuditService;
import com.tang.Service.UserService;
import com.tang.bean.Audit;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-14 15:12
 */
@Controller
public class AuditController {

    @Autowired
    private AuditService auditServiceImpl;

    @Autowired
    private ArticleService articleServiceImpl;

    @Autowired
    private UserService userServiceImpl;

//  查询所有未审核的记录
    @GetMapping("/admin/audits")
    @ResponseBody
    public PageBean<Audit> selectAllAudit(@RequestParam(defaultValue = "1") Integer currentPage,
                                      @RequestParam(defaultValue = "5") Integer pageSize){
        System.out.println("currentPage:"+currentPage+"-->pageSize:"+pageSize);
        PageBean<Audit> pageBean = auditServiceImpl.selectAllAudit(currentPage,pageSize);
        return pageBean;
    }

//  查询指定用户的审核记录
    @GetMapping("/user/audits")
    @ResponseBody
    public PageBean<Audit> selectByUserId(@RequestParam(defaultValue = "1") Integer currentPage,
                                          @RequestParam(defaultValue = "5") Integer pageSize,
                                          HttpSession httpSession){
        User user = (User)httpSession.getAttribute("user");

        PageBean<Audit> pageBean = auditServiceImpl.selectByUserId(currentPage, pageSize, user.getId());

        return pageBean;
    }
//    更新记录审核的状态
    @PostMapping("/admin/audit/update")
    @ResponseBody
    public ResultBean updateAudit(Integer status,Integer auditId,
                                  Integer articleId,String msg,Integer uid){

        ResultBean resultBean = new ResultBean();
//        更新审核状态
        Integer flage_1 = auditServiceImpl.updateAudit(status,auditId,msg);
//      更新文章状态
        Integer flage_2 = articleServiceImpl.updateArticle(status,articleId);


        if (flage_1 == 1 && flage_2 == 1){

            //        用户文章数+1
            userServiceImpl.updateArticleCount(uid);
            System.out.println("审核状态更新,uid="+uid);

            resultBean.setFlage(1);
        }

        return resultBean;
    }

}
