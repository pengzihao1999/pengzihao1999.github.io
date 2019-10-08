package com.pzh.blog.handlers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@ControllerAdvice
public class ControlExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //得到请求路径，得到异常信息，时间，抛出异常到对应的界面
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionhandler(HttpServletRequest request,Exception e) throws Exception {
        //请求路径
        String requestURL = request.getRequestURL().toString();
        //异常信息
        String errormsg = e.getMessage();
        //时间
        String datetime = new Date().toString();
        logger.error("Requst URL : {}，Exception : {} Time : {} ", requestURL,errormsg,datetime);
        //如果是带有状态码的异常，直接抛出，Springboot会到templates/error下对应的页面进行显示
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        //如果是没有带状态码的普通异常，就会显示错误信息到templates/error/error.html下

        ModelAndView model = new ModelAndView();
        model.addObject("requesturl",requestURL);
        model.addObject("errormsg",errormsg);
        model.addObject("datatime",datetime);
        model.setViewName("error/error");

        return model;
    }
}
