package com.edmar.restfulcrud.controller;

import com.edmar.restfulcrud.exception.UserNotFound;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//这个看一下

public class MyExceptionController {

    //这样写浏览器和客户端都是json
//    @ResponseBody//如果不写这个 返回到哪里去了？
//    @ExceptionHandler(UserNotFound.class)
//    public Map<String, Object> handlerException(Exception e) {
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//
//        return map;
//    }

    @ExceptionHandler(UserNotFound.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        //传入自己的默认状态码


        request.setAttribute("javax.servlet.error.status_code",400);

        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
