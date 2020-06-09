package ctgu.service;

import ctgu.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void addUser(UserInfo user) throws Exception;

    UserInfo findByUsername(String username) throws Exception;

    void updateUser(UserInfo user) throws Exception;
}
