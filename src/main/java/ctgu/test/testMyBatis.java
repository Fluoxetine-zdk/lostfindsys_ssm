package ctgu.test;

import ctgu.dao.IUserDao;

import ctgu.entity.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

public class testMyBatis {
    @Test
    public void run1() throws Exception {
        //添加配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SQLSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        IUserDao dao = session.getMapper(IUserDao.class);
        //查数据
        List<UserInfo> list = dao.findAll();
        for (UserInfo user : list){
            System.out.println(user);
        }
        //关闭资源
        session.close();
        in.close();
    }
}
