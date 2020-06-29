package ctgu.controller;

import com.github.pagehelper.PageInfo;
import ctgu.entity.UserInfo;
import ctgu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/userPersonalCenter.do")
    public ModelAndView userFindByUsername(String username) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findByUsername(username);
        mv.addObject("user",user);
        mv.setViewName("user/personalCenter");
        return mv;
    }

    @RequestMapping("/userPersonalCentertoUpdate.do")
    public ModelAndView userFindByUsername2(String username) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findByUsername(username);
        mv.addObject("user",user);
        mv.setViewName("user/personalCenter-userUpdate");
        return mv;
    }

    @RequestMapping("/usertoUpdate.do")
    public ModelAndView updateUserByUser(UserInfo userInfo) throws Exception {
        ModelAndView mv = new ModelAndView();
        userService.updateByUser(userInfo);
        UserInfo user = userService.findByUsername(userInfo.getUsername());
        mv.addObject("user",user);
        mv.setViewName("user/personalCenter");
        return mv;
    }

    @RequestMapping("register.do")
    public String Register(UserInfo user) throws Exception {

        userService.addUser(user);
        return "redirect:login.jsp";
    }




    //    @RequestMapping("/backstage/user/findAll.do")
//    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size) throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<UserInfo> userList = userService.findAll(page,size);
//        PageInfo pageInfo = new PageInfo(userList);
//        mv.addObject("pageInfo",pageInfo);
//        mv.setViewName("backstage/user-list");
//        return mv;
//    }
//
//
//
//    @RequestMapping("/backstage/user/addUser.do")
//    public String addUser(UserInfo userInfo) throws Exception {
//        userService.addUser(userInfo);
//        return "redirect:findAll.do";
//    }
//
//    @RequestMapping("/backstage/user/findByUsername.do")
//    public ModelAndView findByUsername(String username) throws Exception{
//        ModelAndView mv = new ModelAndView();
//        UserInfo user = userService.findByUsername(username);
//        mv.addObject("user",user);
//        mv.setViewName("backstage/user-update");
//        return mv;
//    }

    //    @RequestMapping("/backstage/user/updateUser.do")
//    public String updateUser(UserInfo user) throws Exception {
//        userService.updateUser(user);
//        return "redirect:findAll.do";
//    }


}
