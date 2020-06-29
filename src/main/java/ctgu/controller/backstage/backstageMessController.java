package ctgu.controller.backstage;

import com.github.pagehelper.PageInfo;
import ctgu.entity.Message;
import ctgu.service.IMessService;
import ctgu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class backstageMessController {
    @Autowired
    private IMessService messService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/backstage/message/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Message> messageList = messService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(messageList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("backstage/message-list");
        return mv;
    }

    @RequestMapping("/backstage/message/addMess.do")
    public String addMess(Message message) throws Exception {
        messService.addMess(message);
        return "redirect:findAll.do";
    }

    @RequestMapping("/backstage/message/findByMessId.do")
    public ModelAndView backstageFindByMessId(Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Message message = messService.findByMessId(id);
        mv.addObject(message);
        mv.setViewName("backstage/message-update");
        return mv;
    }

    @RequestMapping("/backstage/message/updateMess.do")
    public String updateMess(Message message){
        messService.updateMess(message);
        return "redirect:findAll.do";
    }

    @RequestMapping("/backstage/message/deleteMess.do")
    public String deleteMess(Integer id){
        messService.deleteMess(id);
        return "redirect:findAll.do";
    }
}
