package com.wangzhen.spbbloguser.controller;

import com.wangzhen.spbbloguser.domain.User;
import com.wangzhen.spbbloguser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登录失败，用户名或者密码错误！");
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String registerUser(User user) {
        userService.registerUser(user);
        System.out.println("user.getName():"+user.getName());
        return "redirect:/login";
    }
}
