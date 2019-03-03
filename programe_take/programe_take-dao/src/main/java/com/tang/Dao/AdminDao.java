package com.tang.Dao;

import com.tang.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 * @create 2019-02-18 11:07
 */
@Mapper
public interface AdminDao {

    //    获取所有用户数据
    @Select("select * from user where username != 'admin'")
    public List<User> selectUserAll(Integer start);

    @Select("select count(*) from user where username != 'admin'")
    public Long countRecord();

//    根据用户名查询用户
    @Select("select * from user where username like '%${username}%'")
    @MapKey("id")
    public Map<Integer,User> selectByUserName(@Param("username") String username);

    //  查询当前用户是否存在
    @Select("select count(*) from user where username = 'admin' and password = #{password}")
    public Long getCountByUserNamePassword(String password);
//    用户更新
    public Long updateUser(User user);


}
