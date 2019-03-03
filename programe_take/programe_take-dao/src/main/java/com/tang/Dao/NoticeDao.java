package com.tang.Dao;

import com.tang.bean.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author ASUS
 * @create 2019-02-27 17:59
 */
@Mapper
public interface NoticeDao {

    @Insert("insert into notice values(null,#{content})")
    public Integer addNotice(Notice notice);

    @Select("select * from notice where id = #{id}")
    public Notice selectById(Integer id);

    @Update("update notice set content = #{content} where id = #{id}")
    public Integer updateNotic(Notice notice);

}
