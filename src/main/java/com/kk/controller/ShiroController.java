package com.kk.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/31 16:09
 * @Description:
 */
@Controller
@RequestMapping("/shiro")
public class ShiroController {

    @RequestMapping("hello")
    public ModelAndView hello(ModelAndView modelAndView){
       modelAndView.addObject("key","value");
       modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping("add")
    public String add(){
       return "user/add";
    }

    @RequestMapping("update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("login")
    public String login(String username,String password,Model model){
        if(username==null || password==null){
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            return "redirect:/shiro/hello";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            return "login";
        }catch (AuthenticationException e){
            model.addAttribute("msg","其他错误");
            return "login";
        }
    }

    @RequestMapping("unauth")
    public String unauth(){
        return "unauth";
    }
}
