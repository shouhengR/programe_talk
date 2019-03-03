package com.tang.web;

import com.tang.Service.NoticeService;
import com.tang.bean.Notice;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ASUS
 * @create 2019-02-27 18:12
 */
@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeServiceImpl;

    @PostMapping("/notice/add")
    public ResultBean addNotice(Notice notice){
        return noticeServiceImpl.addNotice(notice);
    }

    @GetMapping("/notice/{id}")
    public Notice selectById(@PathVariable("id") Integer id){
        return noticeServiceImpl.selectById(id);
    }

    @PostMapping("/notice/update")
    public ResultBean updateNotic(Notice notice){
        System.out.println(notice);
        return noticeServiceImpl.updateNotic(notice);
    }

}
