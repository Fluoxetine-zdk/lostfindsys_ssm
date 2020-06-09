package ctgu.controller;

import ctgu.entity.Message;
import ctgu.service.IMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessService messService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Message> messageList = messService.findAll();
        mv.addObject(messageList);
        mv.setViewName("backstage/message-list");
        return mv;
    }

    @RequestMapping("/addMess.do")
    public String addMess(Message message) throws Exception {
        messService.addMess(message);
        return "redirect:findAll.do";
    }
}
