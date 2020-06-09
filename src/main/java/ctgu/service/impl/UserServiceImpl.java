package ctgu.service.impl;

import ctgu.dao.IUserDao;
import ctgu.entity.UserInfo;
import ctgu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userdao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userdao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getClassname()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(String classname){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_"+classname));
        return list;
    }


    @Override
    public List<UserInfo> findAll() throws Exception {
        return userdao.findAll();
    }

    @Override
    public void addUser(UserInfo user) throws Exception {
        userdao.addUser(user);
    }

    @Override
    public UserInfo findByUsername(String username) throws Exception {
        return userdao.findByUsername(username);
    }

    @Override
    public void updateUser(UserInfo user) throws Exception {
        userdao.updateUser(user);
    }

}
