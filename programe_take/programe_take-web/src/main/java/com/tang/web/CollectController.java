package com.tang.web;

import com.tang.Service.CollectService;
import com.tang.bean.Collect;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author ASUS
 * @create 2019-02-15 15:48
 */
@Controller
public class CollectController {

    @Autowired
    private CollectService collectServiceImpl;

//    查询指定用户的收藏记录
    @GetMapping("/user/collect")
    @ResponseBody
    public PageBean<Collect> selectByUserId(@RequestParam(defaultValue = "1") Integer currentPage,
                                            @RequestParam(defaultValue = "5") Integer pageSize,HttpSession session){

        User user = (User)session.getAttribute("user");

        PageBean<Collect> pageBean = collectServiceImpl.selectAllByUserId(currentPage, pageSize, user.getId());

        return pageBean;
    }

//    取消收藏                              收藏id
    @DeleteMapping("/user/collect/delete/{cid}")
    @ResponseBody
    public ResultBean deleteCollect(@PathVariable("cid") Integer cid){

        ResultBean resultBean = new ResultBean();

        Integer result = collectServiceImpl.deleteCollect(cid);

        resultBean.setFlage(result);

        return resultBean;
    }
//  文章收藏                      文章id
    @PostMapping("/collect/add/{aid}")
    @ResponseBody
    public ResultBean addCollect(@PathVariable("aid") Integer aid,HttpSession session){

        ResultBean resultBean = new ResultBean();

        User user = (User) session.getAttribute("user");

        if (user != null){

//            检查此文章是否已经被该用户收藏过
            Long flage = collectServiceImpl.checkRepeatCollect(user.getId(), aid);

            if (flage.intValue() != 1){

                Collect collect = new Collect();
                collect.setAid(aid);
                collect.setUid(user.getId());
                collect.setTime(new Date());
//          添加一个当前用户的收藏记录
                resultBean = collectServiceImpl.addCollect(collect);
            }else {

                resultBean.setMsg("该文章你已收藏过了!");
                resultBean.setFlage(1);
            }

        }else {
            resultBean.setFlage(0);
            resultBean.setMsg("暂时无权操作,请先登录!");
        }

        return resultBean;

    }

}
