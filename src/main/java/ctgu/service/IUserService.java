package ctgu.service;

import ctgu.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {


    public List<UserInfo> findAll() throws Exception;
    public void addUser(UserInfo user) throws Exception;
    public UserInfo findByUsername(String username) throws Exception;
}
