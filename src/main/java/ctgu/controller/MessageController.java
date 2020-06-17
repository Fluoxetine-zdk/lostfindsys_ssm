package ctgu.controller;

import com.github.pagehelper.PageInfo;
import ctgu.entity.LeaveMessage;
import ctgu.entity.Message;
import ctgu.entity.UserInfo;
import ctgu.service.ILeaveMessService;
import ctgu.service.IMessService;
import ctgu.service.IUserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
public class MessageController {

    @Autowired
    private IMessService messService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ILeaveMessService leaveMessService;

    @RequestMapping("/backstage/message/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Message> messageList = messService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(messageList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("backstage/message-list");
        return mv;
    }



    @RequestMapping("/addMess.do")
    public String addMess(Message message) throws Exception {
        messService.addMess(message);
        return "redirect:findAll.do";
    }

    @RequestMapping("/backstage/message/findByMessId.do")
    public ModelAndView backstageFindByMessId(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Message message = messService.findByMessId(id);
        mv.addObject(message);
        mv.setViewName("backstage/message-update");
        return mv;
    }

    @RequestMapping("/userfindByMessId.do")
    public ModelAndView userFindByMessId(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Message message = messService.findByMessId(id);
        UserInfo user = userService.findByUsername(message.getUsername());
        List<LeaveMessage> allLeaveMessList = leaveMessService.findAllLeaveMess(id);
        mv.addObject("message",message);
        mv.addObject("user",user);
        mv.addObject("allLeaveMessList",allLeaveMessList);
        mv.setViewName("user/messageDetails");
        return mv;
    }

    @RequestMapping("/findByMessId.do")
    public ModelAndView FindByMessId(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Message message = messService.findByMessId(id);
        UserInfo user = userService.findByUsername(message.getUsername());
        List<LeaveMessage> allLeaveMessList = leaveMessService.findAllLeaveMess(id);
        mv.addObject("message",message);
        mv.addObject("user",user);
        mv.addObject("allLeaveMessList",allLeaveMessList);
        mv.setViewName("messageDetails");
        return mv;
    }

    @RequestMapping("/backstage/message/updateMess.do")
    public String updateMess(Message message){
        messService.updateMess(message);
        return "redirect:findAll.do";
    }

    @RequestMapping("/backstage/message/deleteMess.do")
    public String deleteMess(int id){
        messService.deleteMess(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findByClassMess.do")
    public ModelAndView findByClassMess(int classmess,@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "10") int size){
        ModelAndView mv = new ModelAndView();
        List<Message> messageList = messService.findByClassMess(classmess,page,size);
        PageInfo pageInfo = new PageInfo(messageList);
        mv.addObject("pageInfo",pageInfo);
        if(classmess == 0){
            mv.setViewName("lostMore");
        }
        if(classmess == 1){
            mv.setViewName("findMore");
        }
        return mv;
    }

    @RequestMapping("/findSomeMess.do")
    public ModelAndView mianPageMessShow(){
        ModelAndView mv = new ModelAndView();
        List<Message> someLostMess = messService.findSomeMessByClassmess(0, 1, 5);
        List<Message> someFindMess = messService.findSomeMessByClassmess(1, 1, 5);
        mv.addObject("someFindMess",someFindMess);
        mv.addObject("someLostMess",someLostMess);
        mv.setViewName("main");    //跳转到未登录首页和登录后首页，写两个方法
        return mv;
    }

    @RequestMapping("/usermain.do")
    public ModelAndView userMainPageMessShow(){
        ModelAndView mv = new ModelAndView();
        List<Message> someLostMess = messService.findSomeMessByClassmess(0, 1, 5);
        List<Message> someFindMess = messService.findSomeMessByClassmess(1, 1, 5);
        mv.addObject("someFindMess",someFindMess);
        mv.addObject("someLostMess",someLostMess);
        mv.setViewName("user/usermain");
        return mv;
    }

    @RequestMapping("/releaseMess.do")
    public String releaseMess(Message message,HttpServletRequest request,@RequestParam(value="file")MultipartFile pictureFile) throws Exception {


        //这个RequestParam(value="file")的是我们在jsp的name=“file”
        // 使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取文件的扩展名
        String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
        // 设置图片上传路径
        String url = request.getSession().getServletContext()
                .getRealPath("/img");
        System.out.println(url);
        // 以绝对路径保存重名命后的图片
        pictureFile.transferTo(new File(url + "/" + name + "." + ext));
        message.setImgpath(name+"."+ext);
        messService.addMess(message);
        return "redirect:usermain.do";
    }

    @RequestMapping("/userFindByClassMess.do")
    public ModelAndView userFindByClassMess(int classmess,@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "10") int size){
        ModelAndView mv = new ModelAndView();
        List<Message> messageList = messService.findByClassMess(classmess, page, size);
        PageInfo pageInfo = new PageInfo(messageList);
        mv.addObject("pageInfo",pageInfo);
        if(classmess == 0){
            mv.setViewName("user/lostMore");
        }
        if(classmess == 1){
            mv.setViewName("user/findMore");
        }
        return mv;
    }

    @RequestMapping("/searchMess.do")
    public ModelAndView searchMess(String keyword,@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size){
        ModelAndView mv = new ModelAndView();
        List<Message> searchMessList = messService.searchMess(page, size, keyword);
        PageInfo pageInfo = new PageInfo(searchMessList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("searchMess");
        return mv;
    }

    @RequestMapping("/searchMessInBackstage.do")
    public ModelAndView searchMessInBackstage(String keyword,@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size){
        ModelAndView mv = new ModelAndView();
        List<Message> searchMessList = messService.searchMess(page,size,keyword);
        PageInfo pageInfo = new PageInfo(searchMessList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("backstage/searchMessage-list");
        return mv;
    }

    @RequestMapping("/searchMessByUser.do")
    public ModelAndView searchMessByUser(String keyword,@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size){
        ModelAndView mv = new ModelAndView();
        List<Message> searchMessList = messService.searchMess(page,size,keyword);
        PageInfo pageInfo = new PageInfo(searchMessList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user/searchMess1");
        return mv;
    }

    @RequestMapping("/backstage/message/findAllLeaveMess.do")
    public ModelAndView findAllLeaveMessageInBackstage(int id,@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size){
        ModelAndView mv = new ModelAndView();
        List<LeaveMessage> allLeaveMessList = leaveMessService.findAllLeaveMess(id,page,size);
        PageInfo pageInfo = new PageInfo(allLeaveMessList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("msgid",id);
        mv.setViewName("backstage/message-leaveMesslist");
        return mv;
    }

    @RequestMapping("backstage/deleteLeaveMess.do")
    public ModelAndView deleteLeaveMess(int id,int msgid){
        ModelAndView mv = new ModelAndView();
        leaveMessService.deleteLeaveMess(id);
        List<LeaveMessage> allLeaveMessList = leaveMessService.findAllLeaveMess(msgid, 1, 5);
        PageInfo pageInfo = new PageInfo(allLeaveMessList);
        mv.addObject(pageInfo);
        mv.setViewName("backstage/message-leaveMesslist");
        return mv;
    }

    @RequestMapping("/addImg.do")
    public void addImg(HttpServletRequest request,@RequestParam(value="file")MultipartFile pictureFile) throws Exception {

        //这个RequestParam(value="file")的是我们在jsp的name=“file”
        // 使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取文件的扩展名
        String ext = FilenameUtils.getExtension(pictureFile
                .getOriginalFilename());
        // 设置图片上传路径
        String url = request.getSession().getServletContext()
                .getRealPath("/img");
        System.out.println(url);
        // 以绝对路径保存重名命后的图片
        pictureFile.transferTo(new File(url + "/" + name + "." + ext));
        // 把图片存储路径保存到数据库









    }

}
