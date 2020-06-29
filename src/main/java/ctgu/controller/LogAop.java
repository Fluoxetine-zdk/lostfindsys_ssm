package ctgu.controller;



import ctgu.entity.SysLog;
import ctgu.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; //开始时间
    private Class clazz; //访问的类
    private Method method;//访问的方法

    //前置通知  主要是获取开始时间，执行的类是哪一个，执行的是哪一个方法
    @Before("execution(* ctgu.controller.backstage.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//当前时间就是开始访问的时间

        clazz = jp.getTarget().getClass(); //具体要访问的类

        String methodName = jp.getSignature().getName(); //获取访问的方法的名称

        Object[] args = jp.getArgs();//获取访问的方法的参数

        //获取具体执行的方法的Method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName); //只能获取无参数的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    //后置通知
    @After("execution(* ctgu.controller.backstage.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        // 获取类上的@RequestMapping对象
        if (clazz != SysLogController.class) {
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {                // 获取方法上的@RequestMapping对象
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String url = ""; // 它的值应该是类上的@RequestMapping的value+方法上的 @RequestMapping的value
                    url = classAnnotation.value()[0] + methodAnnotation.value()[0];

                    SysLog sysLog = new SysLog();
                    // 获取访问时长
                    long time = new Date().getTime() - visitTime.getTime();                    // 将sysLog对象属性封装
                    sysLog.setExecutionTime(time);
                    sysLog.setUrl(url);
                    // 获取ip
                    String ip = request.getRemoteAddr();
                    sysLog.setIp(ip);

                    //获取当前操作的用户
                    String username = null;
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获了当前登录的用户
                    if (!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {//判断是否登录
                        User user = (User) context.getAuthentication().getPrincipal();
                        username = user.getUsername();
                    }
                    sysLog.setUsername(username);

                    sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());

                    sysLog.setVisitTime(visitTime);

                    // 调用Service，调用dao将sysLog insert数据库
                    sysLogService.save(sysLog);
                }
            }

        }

    }
}
