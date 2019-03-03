package com.tang.Dao;

import com.tang.bean.Audit;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-12 11:28
 */
//审核dao
@Mapper
public interface AuditDao {
//    添加审核
    public Integer addAudit(Audit audit);
//    修改审核 0 正在审核 1 成功，2失败
    @Update("update audittable set status = #{statusCode},adminMessage = #{msg} where id = #{id}")
    public Integer updateAudit(@Param("statusCode") Integer statusCode,
                               @Param("id") Integer id,@Param("msg")String msg);
//    查询审核记录
    public List<Audit> selectAllAudit(Integer start);

//    查询指定用户的审核记录
    public List<Audit> selectByUserId(@Param("uid") Integer uid,@Param("start") Integer start);

    @Select("select count(*) from audittable where status = 0")
    public Long countRecord();

    @Select("select count(*) from audittable where uid = #{uid}")
    public Long myCountRecord(Integer uid);

//    根据文章id 删除指定记录
    @Delete("delete from audittable where aid = #{aid}")
    public Long delAuditByAid(Integer aid);
}
