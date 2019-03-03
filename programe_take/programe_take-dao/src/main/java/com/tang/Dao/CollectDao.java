package com.tang.Dao;

import com.tang.bean.Collect;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-15 14:03
 */
@Mapper
public interface CollectDao {
//    添加收藏
    @Insert("insert collect values(null,#{aid},#{uid},#{time})")
    public Integer addCollect(Collect collect);
//    取消收藏
    @Delete("delete from collect where id = #{cid}")
    public Integer deleteCollect(Integer cid);

//  删除指定文章下的收藏记录
    @Delete("delete from collect where aid = #{aid}")
    public Long delCollectByAid(Integer aid);

//    查询指定用户的收藏
    public List<Collect> selectAllByUserId(@Param("uid") Integer uid,@Param("start") Integer start);

    @Select("select count(*) from collect")
    public Long countRecord();

//  检查文章是否已经被收藏
    @Select("select count(*) from collect where aid = #{aid} and uid = #{uid}")
    public Long checkRepeatCollect(@Param("uid") Integer uid,@Param("aid") Integer aid);
}
