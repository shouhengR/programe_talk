package com.tang.web;

import com.tang.Service.CategoryService;
import com.tang.bean.Category;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-03 10:34
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryServiceImpl;

    @GetMapping("/category")
    @ResponseBody
    public Map<Integer,Category> selectAll(){

        Map<Integer, Category> categoryMap = categoryServiceImpl.selectAll();

        return categoryMap;
    }

    @GetMapping("/category/update/{id}")
    @ResponseBody
    public ResultBean updateVisitNumber(@PathVariable("id") Integer id) {

        return categoryServiceImpl.updateVisitNumber(id);

    }

}
