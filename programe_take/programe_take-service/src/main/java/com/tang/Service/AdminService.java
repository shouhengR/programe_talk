package com.tang.Service;

import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.User;

import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-18 11:08
 */
public interface AdminService {

    public PageBean<User> selectUserAll(Integer currentPage, Integer pageSize);

    public Map<Integer,User> selectByUserName(String userName);

    public ResultBean getCountByUserNamePassword(String password);

    public ResultBean updateUser(User user);
}
