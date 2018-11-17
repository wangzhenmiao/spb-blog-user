package com.wangzhen.spbbloguser.controller;


import com.wangzhen.spbbloguser.domain.User;
import com.wangzhen.spbbloguser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * @ClassName UserController
 * @Description
 * @Author wangzhen
 * @Date 2018/11/10 下午4:20
 **/

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     *
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("title","用户管理");
        return new ModelAndView("users/list","userModel",model);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view (@PathVariable("id")Long id,Model model){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user",user.get());
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/view","userModel",model);
    }

    /**
     * 获取创建表单数据
     *
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null,null,null));
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * 保存或修改用户
     *
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user){
        userRepository.save(user);
        return new ModelAndView("redirect:/users");//重定向到list页面
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users"); //重定向到list页面
    }

    /**
     * 修改获取用户的界面.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id,Model model){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user",user.get());
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form","userModel",model);

    }


}
