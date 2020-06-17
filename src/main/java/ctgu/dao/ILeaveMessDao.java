package ctgu.dao;

import ctgu.entity.LeaveMessage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILeaveMessDao {
    @Select("select * from leavemess where msgid = #{msgid}")
    List<LeaveMessage> findLeaveMessByMsgid(int msgid);

    @Delete("delete from leavemess where id = #{id}")
    void deleteLeaveMess(int id);
}
