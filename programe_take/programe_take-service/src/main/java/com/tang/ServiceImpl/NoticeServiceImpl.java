package com.tang.ServiceImpl;

import com.tang.Dao.NoticeDao;
import com.tang.Service.NoticeService;
import com.tang.bean.Notice;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ASUS
 * @create 2019-02-27 18:04
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    public NoticeDao noticeDaoImpl;

    @Override
    public ResultBean addNotice(Notice notice) {

        ResultBean resultBean = new ResultBean();
        resultBean.setMsg("添加失败!");

        resultBean.setFlage(noticeDaoImpl.addNotice(notice));

        if (resultBean.getFlage() == 1){

            resultBean.setMsg("添加成功!");
        }


        return resultBean;
    }

    @Override
    public Notice selectById(Integer id) {

        return noticeDaoImpl.selectById(id);
    }

    @Override
    public ResultBean updateNotic(Notice notice) {

        ResultBean resultBean = new ResultBean();

        resultBean.setMsg("修改失败!");

        resultBean.setFlage(noticeDaoImpl.updateNotic(notice));

        if (resultBean.getFlage() == 1){

            resultBean.setMsg("修改成功!");
        }

        return resultBean;
    }
}
