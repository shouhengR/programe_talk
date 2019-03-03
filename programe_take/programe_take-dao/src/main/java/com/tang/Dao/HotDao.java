package com.tang.Dao;

import com.tang.bean.Hot;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-02-19 21:29
 */
@Mapper
public interface HotDao {

//    推荐为热门文章
    @Insert("insert hot values(null,#{aid},#{uid},#{time})")
    public Long addHotArticle(Hot hot);

//    取消热门文章
    @Delete("delete from hot where aid = #{aid} and uid = #{uid}")
    public  Long delHotArticle(Hot hot);

//  删除热门文章的推荐记录
    @Delete("delete from hot where aid = #{aid}")
    public Long delHotByAid(Integer aid);

//    查询所有
    public List<Hot> selectAllHotArticle(Integer strat);
    @Select("select count(*) from hot")
    public Long countRecord();
}
