package com.wangzhen.spbbloguser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理控制器.
 *
 * @ClassName AdminController
 * @Description
 * @Author wangzhen
 * @Date 2018/11/10 下午4:02
 **/

@Controller
@RequestMapping("/admins")
public class AdminController {

    @GetMapping
    public ModelAndView listUsers(Model model){
        return new ModelAndView("admin/index","menuList",model);
    }
}
