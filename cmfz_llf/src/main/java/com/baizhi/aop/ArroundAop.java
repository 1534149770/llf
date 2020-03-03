package com.baizhi.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

public class ArroundAop implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        /*
        *
        * 什么人 什么时间 干了什么 是否成功
        * */

        ServletRequestAttributes s = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = s.getRequest().getSession();
        String adminName = (String) session.getAttribute("admin.username");

        //时间
        Date date = new Date();
        //事件
        Method method = mi.getMethod();
        //拿类对象，反射
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        //通过反射的事例调用方法
        String name = annotation.value();
        //是否成功
        boolean flag = false;
        Object proceed = null;
        try{
            proceed = mi.proceed();
            flag = true;
        }
        catch (Exception a){
            a.printStackTrace();
        }
        System.out.println(adminName+"管理员在"+date+"执行了"+name+"成功了么？"+flag);
        return proceed;
    }
}
