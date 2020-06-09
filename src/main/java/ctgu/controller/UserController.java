package ctgu.controller;

import ctgu.entity.UserInfo;
import ctgu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;



    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("backstage/user-list");
        return mv;
    }



    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo) throws Exception {
        userService.addUser(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/updateUser.do")
    public ModelAndView findByUsername(String username) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findByUsername(username);
        mv.addObject("user",user);
        mv.setViewName("backstage/user-update");
        return mv;
    }

}
