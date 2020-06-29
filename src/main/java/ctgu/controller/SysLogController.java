package ctgu.controller;

import com.github.pagehelper.PageInfo;
import ctgu.entity.SysLog;
import ctgu.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/backstage")
@Controller
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAllSysLog.do")
    public ModelAndView findAllSysLog(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(sysLogs);
        mv.addObject(pageInfo);
        mv.setViewName("backstage/syslog-list");
        return mv;
    }
}
