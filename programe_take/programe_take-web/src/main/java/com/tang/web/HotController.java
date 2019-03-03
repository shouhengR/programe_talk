package com.tang.web;

import com.tang.Service.HotService;
import com.tang.bean.Hot;
import com.tang.bean.PageBean;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author ASUS
 * @create 2019-02-19 21:36
 */
@RestController
public class HotController {

    @Autowired
    public HotService hotServiceImpl;

    @PutMapping("/hot/add")
    public ResultBean addHotArticle(Hot hot){

        hot.setTime(new Date());

        System.out.println(hot);

        return hotServiceImpl.addHotArticle(hot);
    }

    @DeleteMapping("/hot/del")
    public ResultBean delHotArticle(Hot hot) {

        System.out.println(hot);

        return hotServiceImpl.delHotArticle(hot);
    }

    @GetMapping("/hot/all")
    public PageBean<Hot> selectAll(@RequestParam(defaultValue = "1") Integer currentPage,
                                   @RequestParam(defaultValue = "5") Integer pageSize){
        return hotServiceImpl.selectAll(currentPage,pageSize);
    }

}
