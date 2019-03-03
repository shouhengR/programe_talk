package com.tang.Service;

import com.tang.bean.Notice;
import com.tang.bean.ResultBean;

/**
 * @author ASUS
 * @create 2019-02-27 18:04
 */
public interface NoticeService {

    public ResultBean addNotice(Notice notice);

    public Notice selectById(Integer id);

    public ResultBean updateNotic(Notice notice);
}
