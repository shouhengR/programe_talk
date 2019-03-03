package com.tang.ServiceImpl;

import com.tang.Dao.UserDao;
import com.tang.Service.UserService;
import com.tang.bean.Article;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-01-30 15:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDaoImpl;

    @Override
    public User getUserById(Integer id) {

        return userDaoImpl.getUserById(id);

    }

    @Override
    public User getUserByUserName(String username) {

        return userDaoImpl.getUserByUserName(username);
    }
//  登陆验证
    @Override
    public ResultBean getCountByUserNamePassword(String username, String password) {
//
        Long count = userDaoImpl.getCountByUserNamePassword(username, password);

        ResultBean resultBean = new ResultBean();
        resultBean.setFlage(0);
        resultBean.setMsg("登陆失败！请重试。");

        if (count.intValue() == 1) {
            resultBean.setMsg("登陆成功！");
            resultBean.setFlage(1);
        }

        return resultBean;
    }

    @Override
    public Integer registerUser(User user) {

        return userDaoImpl.registerUser(user);
    }

    @Override
    public ResultBean checkUserName(String username) {
//        检查用户名是否重复
        Long checkUserName = userDaoImpl.getCountByUserName(username);

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(checkUserName.intValue());

        return resultBean;
    }

    @Override
    public Integer updateUserDetails(User user) {
        return userDaoImpl.updateUser(user);
    }

    @Override
    public Integer updateArticleCount(Integer uid) {
        return userDaoImpl.updateArticleCount(uid);
    }

    @Override
    public Integer delUser(Integer[] delArr) {

        for (int i = 0;i < delArr.length;i++){

            Long flage =  userDaoImpl.delUser(delArr[i]);

            if (flage.intValue() == 0){
                return 0;
            }
        }

        return 1;
    }

}
