package ctgu.dao;

import ctgu.entity.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageDao {
    @Select("select * from message ORDER BY createdate DESC")
    List<Message> findAll() throws Exception;

    @Insert("insert into message (username,description,class_message,reward,address,imgpath) values(#{username},#{description},#{class_message},#{reward},#{address},#{imgpath})")
    void addMsee(Message message);

    @Select("select * from message where id = #{id}")
    Message findByMessId(int id);

    @Update("update message set description = #{description},address = #{address},bastus = #{bastus},class_message = #{class_message},reward = #{reward} where id = #{id}")
    void updateMess(Message message);

    @Select("select * from message where class_message = #{classmess} ORDER BY createdate DESC")
    List<Message> findByClassmess(int classmess);

    @Delete("delete from message where id = #{id}")
    void deleteMess(int id);

    @Select("select * from message where description like CONCAT('%',#{keyword},'%') ORDER BY createdate DESC ")
    List<Message> searchByDescription(String keyword);

    @Select("select * from message where username = #{username} ORDER BY createdate DESC")
    List<Message> findUserOwnMess(String username);
}
