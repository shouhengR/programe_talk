package com.tang.ServiceImpl;

import com.tang.Dao.AdminDao;
import com.tang.Service.AdminService;
import com.tang.bean.Article;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-18 11:09
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDaoImpl;

    @Override
    public PageBean<User> selectUserAll(Integer currentPage, Integer pageSize) {

        PageBean<User> pageBean = new PageBean<>();

        Long count = adminDaoImpl.countRecord();
//        设置总记录数
        pageBean.setRecordCount(count.intValue());

        System.out.println("countRecord "+count.intValue());

//        每页的大小
        pageBean.setPageSize(pageSize);
//        总页数
        Integer countPage = (count.intValue() + pageSize - 1) / pageSize;
        pageBean.setCountPage(countPage);

        if (countPage != 0){
            if (currentPage > countPage){
                currentPage = countPage;
            }
        }
//        当前页
        pageBean.setCurrentPage(currentPage);

        Integer start = (currentPage - 1) * pageSize;
//        分页查询
        List<User> users = adminDaoImpl.selectUserAll(start);

        pageBean.setList(users);

        return pageBean;
    }

    @Override
    public Map<Integer, User> selectByUserName(String userName) {
        return adminDaoImpl.selectByUserName(userName);
    }

    @Override
    public ResultBean getCountByUserNamePassword(String password) {

        Long count = adminDaoImpl.getCountByUserNamePassword(password);

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
    public ResultBean updateUser(User user) {

        ResultBean resultBean = new ResultBean();

        Long flage = adminDaoImpl.updateUser(user);

        resultBean.setFlage(flage.intValue());

        return resultBean;
    }
}
