package com.tang.Dao;

import com.tang.bean.Concerns;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-15 17:28
 */
@Mapper
public interface ConcernDao {
//    添加关注
    @Insert("insert into concerns value(null,#{auid},#{buid})")
    public Integer addConcern(Concerns concerns);
//    取消关注
    @Delete("delete from concerns where id = #{id}")
    public Integer delConcerns(Integer id);
//    查询指定用户的关注记录
    public List<Concerns> selectByUserId(Integer auid);

    //  检查文章是否已经被收藏
    @Select("select count(*) from concerns where auid = #{auid} and buid = #{buid}")
    public Long checkRepeatConcern(@Param("auid") Integer auid, @Param("buid") Integer buid);
}
