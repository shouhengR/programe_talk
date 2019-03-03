package com.tang.Service;

import com.tang.bean.Audit;
import com.tang.bean.PageBean;

/**
 * @author ASUS
 * @create 2019-02-12 11:42
 */
public interface AuditService {

    public Integer addAudit(Audit audit);

    public Long delAuditByAid(Integer aid);

    public Integer updateAudit(Integer statusCode, Integer id,String msg);

    public PageBean<Audit> selectAllAudit(Integer currentPage, Integer pageSize);

    public PageBean<Audit> selectByUserId(Integer currentPage, Integer pageSize,Integer uid);
}
