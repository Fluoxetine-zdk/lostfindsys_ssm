package ctgu.dao;

import ctgu.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IMessageDao {
    @Select("select * from message")
    public List<Message> findAll() throws Exception;

    @Insert("insert into message (username,description,class_message,bastus) values(#{username},#{description},#{class_message},#{bastus})")
    public void addMsee(Message message);
}
