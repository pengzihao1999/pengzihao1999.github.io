package com.pzh.blog.controls.admin;

import com.pzh.blog.domain.User;
import com.pzh.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class LoginControl {

    @Autowired
    private IUserService userService;
    //跳转到登录页面
    @GetMapping
    public String loginPage(){

        return "admin/login";
    }

    //进行用户名密码校验
    @PostMapping("/login")
    public String login(String username, String password,
                        HttpSession session){
        User loginUser  = userService.checkUser(username,password);
        if(loginUser!=null){
            loginUser.setPassword(null);
            session.setAttribute("user",loginUser);
            //登录成功 重定向到blog请求
            return "redirect:/admin/blog";
        }else {
            //输入错误进行重定向
            session.setAttribute("msg","您的用户名或密码输入错误");
            return "redirect:/admin";
        }
    }
    //注销用户
    //重定向到登录界面
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
