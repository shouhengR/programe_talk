package com.tang.web;

import com.tang.Service.ConcernService;
import com.tang.bean.Collect;
import com.tang.bean.Concerns;
import com.tang.bean.ResultBean;
import com.tang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-15 22:22
 */
@Controller
public class ConcernController {

    @Autowired
    private ConcernService concernServiceImpl;

//    添加关注
    @PostMapping("/concern/add/{buid}")
    @ResponseBody
    public ResultBean addConcern(@PathVariable("buid") Integer buid, HttpSession httpSession){

        ResultBean resultBean = new ResultBean();

        User user = (User) httpSession.getAttribute("user");

        if (user != null){

            //            自己不能关注自己
            if (user.getId() == buid){

                resultBean.setFlage(0);

                resultBean.setMsg("这是自己发表的文章!");

                return resultBean;
            }

//            检查此用户是否已经被该用户关注过
            Long flage = concernServiceImpl.checkRepeatConcern(user.getId(),buid);

            if (flage.intValue() != 1){

                Concerns concerns = new Concerns();

                concerns.setAuid(user.getId());

                concerns.setBuid(buid);

//          添加一个当前用户的关注记录
                resultBean = concernServiceImpl.addConcern(concerns);
            }else {

                resultBean.setMsg("该用户你已关注过了!");
                resultBean.setFlage(1);
            }

        }else {
            resultBean.setFlage(0);
            resultBean.setMsg("暂时无权操作,请先登录!");
        }

        return resultBean;
    }

//    取消关注
    @GetMapping("/user/concern/del")
    @ResponseBody
    public ResultBean delConcerns(Integer id){

        return concernServiceImpl.delConcern(id);
    }

//   查询指定用户的关注记录
    @GetMapping("/user/concern")
    @ResponseBody
    public List<Concerns> selectByUserId(HttpSession httpSession){

        User user = (User)httpSession.getAttribute("user");

        return concernServiceImpl.selectByUserId(user.getId());

    }



}
