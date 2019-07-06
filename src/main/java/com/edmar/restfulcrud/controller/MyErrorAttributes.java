package com.edmar.restfulcrud.controller;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //这个map是页面和json能获取的字段

        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("err",1);

        //异常处理器携带的数据
        Map<String ,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }
}
