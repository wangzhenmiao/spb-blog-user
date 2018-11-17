package com.wangzhen.spbbloguser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 主页控制器.
 *
 * @ClassName MainController
 * @Description
 * @Author wangzhen
 * @Date 2018/11/10 下午4:12
 **/

@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登录失败，用户名或密码错误！");
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
