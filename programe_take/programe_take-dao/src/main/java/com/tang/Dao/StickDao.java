package com.tang.Dao;

import com.tang.bean.Hot;
import com.tang.bean.Stick;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-21 21:11
 */
@Mapper
public interface StickDao {
    //    推荐为置顶文章
    @Insert("insert top values(null,#{aid},#{uid},#{time})")
    public Long addStickArticle(Stick stick);

    //    取消置顶文章
    @Delete("delete from top where aid = #{aid} and uid = #{uid}")
    public  Long delStickArticle(Stick stick);

    //    删除置顶文章的指定记录
    @Delete("delete from top where aid = #{aid}")
    public  Long delStickByAid(Integer aid);

    //    查询所有
    public List<Stick> selectAllStickArticle(Integer strat);

    @Select("select count(*) from top")
    public Long countRecord();

}
