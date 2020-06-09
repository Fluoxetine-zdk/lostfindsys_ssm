package ctgu.dao;


import ctgu.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserDao {

    @Select("select * from user a,userclass b where username = #{username} and a.classno = b.classno")
//    @Results({
//            @Result(id = true, property = "username", column = "username"),
//            @Result(property = "password", column = "password"),
//            @Result(property = "sex", column = "sex"),
//            @Result(property = "mobile", column = "mobile"),
//            @Result(property = "classname", column = "classname"),
//            @Result(property = "mobile", column = "mobile")
//    })
    public UserInfo findByUsername(String username) throws Exception;

    @Select("select * from user")
    public List<UserInfo> findAll() throws Exception;

    @Insert("insert into user (username,password,mobile) values (#{username},#{password},#{mobile})")
    public void addUser(UserInfo user) throws Exception;

}
