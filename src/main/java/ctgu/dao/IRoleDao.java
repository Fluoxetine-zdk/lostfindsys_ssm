package ctgu.dao;

import org.apache.ibatis.annotations.Select;

public interface IRoleDao {

    @Select("select classname from userclass where classno = #{classno}")
    public String findRoleByClassno(int classno) throws Exception;
}
