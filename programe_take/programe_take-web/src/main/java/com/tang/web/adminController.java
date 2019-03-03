package com.tang.web;

import com.tang.Service.AdminService;
import com.tang.Service.UserService;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-18 11:14
 */
@RestController
public class adminController {

    @Autowired
    private AdminService adminServiceImpl;

    //    admin - 用户管理
    @GetMapping("/admin/users")
    public PageBean<User> adminUserMake(@RequestParam(defaultValue = "1") Integer currentPage,
                                        @RequestParam(defaultValue = "5") Integer pageSize){
        return adminServiceImpl.selectUserAll(currentPage,pageSize);
    }

    //    admin - 用户搜索
    @GetMapping("/admin/users/search")
    public Map<Integer, User> selectUserName(String username){

        return adminServiceImpl.selectByUserName(username);
    }

    //    管理员登录验证
    @GetMapping("/admin/login")
    public ResultBean adminLogin(String password, HttpSession httpSession){
        //        查询用户是否存在，密码是否正确
        ResultBean resultBean = adminServiceImpl.getCountByUserNamePassword(password);
//        存入session 设置其有效时间
        if (resultBean.getFlage() == 1){
//            获取admin
            User user = adminServiceImpl.selectByUserName("admin").get(1);

            if (user != null){
                httpSession.setAttribute("user",user);
                httpSession.setMaxInactiveInterval(36000);
            }
        }

        return resultBean;
    }
// 用户更新
    @PostMapping("/admin/update/user")
    public ResultBean updateUser(User user){

        System.out.println(user);

        ResultBean resultBean = adminServiceImpl.updateUser(user);

        return resultBean;
    }

}
