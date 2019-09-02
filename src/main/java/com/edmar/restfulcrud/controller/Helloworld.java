package com.edmar.restfulcrud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

@Controller
public class Helloworld {

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello","<h1>--nihao!!</h1>");
        map.put("list", Arrays.asList("qqq","www","eee"));
        return "success";
    }

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session) {
        if(!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        map.put("msg","用户名或密码错误");
        return "index";
    }

    @Value("${myaa}")
    String myaa = "myaa..";

    @GetMapping("/aaa")
    @ResponseBody
    public String getProperties() {
        return myaa;
    }
}
