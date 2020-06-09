package ctgu.dao;

import ctgu.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IMessageDao {
    @Select("select * from message")
    public List<Message> findAll() throws Exception;

    @Insert("insert into message (username,description,class_message,reward,address) values(#{username},#{description},#{class_message},#{reward},#{address})")
    public void addMsee(Message message);

    @Select("select * from message where id = #{id}")
    public Message findByMessId(int id);

    @Update("update message set description = #{description},address = #{address},bastus = #{bastus},class_message = #{class_message},reward = #{reward} where id = #{id}")
    void updateMess(Message message);
}
