package com.tang.Service;

import com.tang.bean.Concerns;
import com.tang.bean.ResultBean;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-15 21:53
 */
public interface ConcernService {

    public ResultBean addConcern(Concerns concerns);

    public ResultBean delConcern(Integer id);

    public List<Concerns> selectByUserId(Integer auid);

    public Long checkRepeatConcern(Integer auid,Integer buid);

}
