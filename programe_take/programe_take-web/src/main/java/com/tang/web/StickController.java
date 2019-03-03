package com.tang.web;

import com.tang.Service.StickService;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import com.tang.bean.Stick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ASUS
 * @create 2019-02-21 21:19
 */

@RestController
public class StickController {

    @Autowired
    private StickService stickServiceImpl;

    @PutMapping("/top/add")
    public ResultBean addHotArticle(Stick stick){

        stick.setTime(new Date());

        System.out.println(stick);

        return stickServiceImpl.addStickArticle(stick);
    }

    @DeleteMapping("/top/del")
    public ResultBean delHotArticle(Stick stick) {

        System.out.println(stick);

        return stickServiceImpl.delStickArticle(stick);
    }

    @GetMapping("/top/all")
    public PageBean<Stick> selectAll(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "5") Integer pageSize) {
        return stickServiceImpl.selectAll(currentPage, pageSize);
    }

}
