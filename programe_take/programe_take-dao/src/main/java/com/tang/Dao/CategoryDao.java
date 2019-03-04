package com.tang.Dao;

import com.tang.bean.Category;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-03 10:24
 */
@Mapper
public interface CategoryDao {

    @Select("select * from category")
    @MapKey("id")
    public Map<Integer,Category> selectAll();

    @Update("update category set visitCount = visitCount + 1 where id = #{id}")
    public Integer updateVisitNumber(Integer id);

}
