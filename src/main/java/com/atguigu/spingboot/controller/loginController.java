package com.atguigu.spingboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {

    @PostMapping("/user/login")
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) && password.equals("123456")) {
            //为了防止表单重复提交，可以重定向到main.html
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名密码错误！");
            return "login";
        }
    }
}
