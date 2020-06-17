package ctgu.controller;

import com.github.pagehelper.PageInfo;
import ctgu.entity.Message;
import ctgu.service.impl.MessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/noLogin")
public class noLoginController {
    @Autowired
    private MessServiceImpl messService;

    @RequestMapping("/findSomeMess1.do")
    public ModelAndView noLoginFindSomeMess() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Message> someMessList = messService.findAll(1, 5);
        PageInfo pageInfo = new PageInfo(someMessList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("test");
        return mv;
    }
}
