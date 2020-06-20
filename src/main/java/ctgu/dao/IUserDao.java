package ctgu.dao;


import ctgu.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("select * from user a,userclass b where username = #{username} and a.classno = b.classno")
    UserInfo findByUsername(String username);

    @Select("select * from user")
    List<UserInfo> findAll();

    @Insert("insert into user (username,password,mobile,classno,status) values (#{username},#{password},#{mobile},#{classno},#{status})")
    void addUser(UserInfo user);

    @Update("update user set password = #{password},mobile = #{mobile},email = #{email},classno = #{classno},sex = #{sex},status = #{status} where username = #{username} ")
    void updateUser(UserInfo user);

    @Update("update user set password=#{password},mobile=#{mobile},email=#{email},sex = #{sex} where username = #{username} ")
    void updateByUser(UserInfo user);
}
