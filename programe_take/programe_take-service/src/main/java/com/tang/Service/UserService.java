package com.tang.Service;

import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.User;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-01-30 15:38
 */
public interface UserService {

    public User getUserById(Integer id);

    public User getUserByUserName(String username);

    public ResultBean getCountByUserNamePassword(String username, String password);

    public Integer registerUser(User user);

    public ResultBean checkUserName(String username);

    public Integer updateUserDetails(User user);

    public Integer updateArticleCount(Integer uid);

    Integer delUser(Integer[] delArr);
}
