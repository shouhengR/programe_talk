package com.tang.web;

import com.tang.Service.UserService;
import com.tang.bean.Article;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-01-30 14:58
 */
@RestController
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {

        return userServiceImpl.getUserById(id);
    }

    //    用户登陆验证
    @GetMapping("/user/login")
    public ResultBean getCountByUserName(String username, String password, HttpSession httpSession) {

//        查询用户是否存在，密码是否正确
        ResultBean resultBean = userServiceImpl.getCountByUserNamePassword(username, password);
//        存入session 设置其有效时间
        if (resultBean.getFlage() == 1){

            User user = userServiceImpl.getUserByUserName(username);

            System.out.println(user);

            httpSession.setAttribute("user",user);
            httpSession.setMaxInactiveInterval(36000);
        }

        return resultBean;

    }

    //    用户注册
    @PostMapping("/user/add")
    public Map<String,Integer> registerUser(User user) {

        Map<String,Integer> map = new HashMap<>();

        user.setArticleCount(0);
        user.setDesc("");
        user.setHeaderImg("/upload/default_user.jpeg");
        user.setJointime(new Date());
        user.setDesc("");

        Integer flage = userServiceImpl.registerUser(user);

        map.put("flage",flage);

        return map;

    }
//  注册时检查用户名是否存在
    @GetMapping("/checkName")
    public ResultBean checkRegisterUserName(String username){

        ResultBean resultBean = userServiceImpl.checkUserName(username);

        return resultBean;
    }
//  用户信息更新
    @PostMapping("/user/update")
    public ResultBean updateUserDetails(User user,HttpSession httpSession) {

        System.out.println(user);

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(userServiceImpl.updateUserDetails(user));

        if (resultBean.getFlage() == 1){

            user = userServiceImpl.getUserById(user.getId());

            httpSession.setAttribute("user",user);
            httpSession.setMaxInactiveInterval(36000);
        }

        return resultBean;
    }

    @GetMapping("/user/del")
    public ResultBean delUser(Integer[] delArr){

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(userServiceImpl.delUser(delArr));

//        System.out.println(Arrays.toString(delArr));

        return resultBean;
    }

//    检查用户是否登陆
    @GetMapping("/user/check")
    public ResultBean checkUser(HttpSession session){

        ResultBean resultBean = new ResultBean();

        User user = (User)session.getAttribute("user");

        resultBean.setFlage(0);
        resultBean.setMsg("请你先去登陆!");

        if (user != null){
            resultBean.setFlage(1);
            resultBean.setMsg("");
        }

        return resultBean;
    }

//    用户登出
    @GetMapping("/user/loginOut")
    public ResultBean loginOut(HttpSession session){

        session.invalidate();

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(1);

        return resultBean;
    }


}
