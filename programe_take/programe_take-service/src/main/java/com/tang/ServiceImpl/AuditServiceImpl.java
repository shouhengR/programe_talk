package com.tang.ServiceImpl;

import com.tang.Dao.AuditDao;
import com.tang.Service.AuditService;
import com.tang.bean.Article;
import com.tang.bean.Audit;
import com.tang.bean.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-12 11:43
 */
@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditDao auditDao;

    @Override
    public Integer addAudit(Audit audit) {
        return auditDao.addAudit(audit);
    }

    @Override
    public Long delAuditByAid(Integer aid) {
        return auditDao.delAuditByAid(aid);
    }

    @Override
    public Integer updateAudit(Integer statusCode, Integer id,String msg) {
        return auditDao.updateAudit(statusCode,id,msg);
    }

    @Override
    public PageBean<Audit> selectAllAudit(Integer currentPage, Integer pageSize) {

        PageBean<Audit> pageBean = new PageBean<>();

        Long count = auditDao.countRecord();
//        设置总记录数
        pageBean.setRecordCount(count.intValue());
//        每页的大小
        pageBean.setPageSize(pageSize);

//        总页数
        Integer countPage = (count.intValue() + pageSize - 1) / pageSize;
        pageBean.setCountPage(countPage);
        if (countPage != 0){
            if (currentPage > countPage){
                currentPage = countPage;
            }
        }
//        当前页
        pageBean.setCurrentPage(currentPage);

        Integer start = (currentPage - 1) * pageSize;
//        分页查询
        List<Audit> audits = auditDao.selectAllAudit(start);

        pageBean.setList(audits);

        return pageBean;
    }

    @Override
    public PageBean<Audit> selectByUserId(Integer currentPage, Integer pageSize,Integer uid) {

        PageBean<Audit> pageBean = new PageBean<>();

        Long count = auditDao.myCountRecord(uid);
//        设置总记录数
        pageBean.setRecordCount(count.intValue());
//        每页的大小
        pageBean.setPageSize(pageSize);
//        总页数
        Integer countPage = (count.intValue() + pageSize - 1) / pageSize;

        pageBean.setCountPage(countPage);

        if (countPage != 0){
            if (currentPage > countPage){
                currentPage = countPage;
            }
        }

//        当前页
        pageBean.setCurrentPage(currentPage);

        Integer start = (currentPage - 1) * pageSize;
//        分页查询
        List<Audit> audits = auditDao.selectByUserId(uid,start);

        pageBean.setList(audits);

        return pageBean;
    }
}
