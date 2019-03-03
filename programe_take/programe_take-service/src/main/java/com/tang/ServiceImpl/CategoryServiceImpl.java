package com.tang.ServiceImpl;

import com.tang.Dao.CategoryDao;
import com.tang.Service.CategoryService;
import com.tang.bean.Category;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-03 10:25
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Map<Integer, Category> selectAll() {
        return categoryDao.selectAll();
    }

    @Override
    public ResultBean updateVisitNumber(Integer id) {

        ResultBean resultBean = new ResultBean();

        resultBean.setFlage(categoryDao.updateVisitNumber(id));

        resultBean.setMsg("访问量更新成功!");

        return resultBean;
    }
}
