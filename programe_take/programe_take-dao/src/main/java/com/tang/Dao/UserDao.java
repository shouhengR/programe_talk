package com.tang.Dao;

import com.tang.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ASUS
 * @create 2019-01-30 15:34
 */
@Mapper
public interface UserDao {

//    根据id 获取用户
    @Select("select * from user where id = #{id}")
    public User getUserById(Integer id);
//  根据用户名获取 用户
    @Select("select * from user where username = #{username}")
    public User getUserByUserName(String username);
//    验证用户名是否重复
    @Select("select count(*) from user where username = #{username}")
    public Long getCountByUserName(String username);
//  查询当前用户是否存在
    @Select("select count(*) from user where username = #{username} and password = #{password}")
    public Long getCountByUserNamePassword(@Param("username") String username,@Param("password") String password);
//   用户注册
    public Integer registerUser(User user);
//    资料更新
    @Update("update user set phone = #{phone},sex = #{sex},headerImg = #{headerImg},`desc` = #{desc} where id = #{id}")
    public Integer updateUser(User user);

    @Delete("delete from user where id = #{id}")
    public Long delUser(Integer id);

//    文章数量自加
    @Update("update user set articleCount = articleCount + 1 where id = #{uid}")
    public Integer updateArticleCount(Integer uid);

}
