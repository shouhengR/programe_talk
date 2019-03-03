package com.tang.ServiceImpl;

import com.tang.Dao.ConcernDao;
import com.tang.Service.ConcernService;
import com.tang.bean.Concerns;
import com.tang.bean.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-15 21:53
 */
@Service
public class ConcernServiceImpl implements ConcernService {

    @Autowired
    private ConcernDao concernDao;

    @Override
    public ResultBean addConcern(Concerns concerns) {

        ResultBean resultBean = new ResultBean();

        Integer flage = concernDao.addConcern(concerns);

        if (flage == 1){
            resultBean.setMsg("关注成功!可在'我的关注'中查看!");
        }else {
            resultBean.setMsg("关注失败!错误未知!");
        }

        resultBean.setFlage(flage);

        return resultBean;
    }

    @Override
    public ResultBean delConcern(Integer id) {

        ResultBean resultBean = new ResultBean();

        Integer flage = concernDao.delConcerns(id);

        if (flage == 1){
            resultBean.setMsg("取消关注成功!");
        }else {
            resultBean.setMsg("取消关注失败!错误未知!");
        }

        resultBean.setFlage(flage);

        return resultBean;

    }

    @Override
    public List<Concerns> selectByUserId(Integer auid) {
        return concernDao.selectByUserId(auid);
    }

    @Override
    public Long checkRepeatConcern(Integer auid, Integer buid) {
        return concernDao.checkRepeatConcern(auid, buid);
    }
}
