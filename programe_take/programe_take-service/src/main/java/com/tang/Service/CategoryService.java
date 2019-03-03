package com.tang.Service;

import com.tang.bean.Category;
import com.tang.bean.ResultBean;

import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-03 10:25
 */
public interface CategoryService {

    public Map<Integer,Category> selectAll();

    public ResultBean updateVisitNumber(Integer id);

}
