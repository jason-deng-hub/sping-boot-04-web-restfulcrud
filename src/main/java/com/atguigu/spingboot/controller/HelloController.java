package com.atguigu.spingboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/success")
    public String success() {
        return "atguigu";
    }

//    @RequestMapping({"/","/index.html"})
//    public String index() {
//        return "index";
//    }
}
