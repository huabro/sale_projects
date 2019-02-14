package com.tianyu.controller;

import com.tianyu.common.JsonResult;
import com.tianyu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/20 0020.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "register.html", method = RequestMethod.GET)
    public String register() {
        return "register.jsp";
    }

    @RequestMapping(value = {"login.html", "login"}, method = RequestMethod.POST)
    public ModelAndView loginSuccess(ModelAndView mv, String loginName, String password, HttpServletRequest request) {
        int flag = userService.loginJudge(loginName, password);
        switch (flag) {
            case 0:
                mv.addObject("msg", "用户不存在");
                mv.setViewName("login.jsp");

                return mv;
            case 1:
                HttpSession session = request.getSession();
                session.setAttribute("loginName", loginName);
                mv.setViewName("index.jsp");
                return mv;
            case 2:
                mv.addObject("msg1", "密码错误");
                mv.setViewName("login.jsp");
                return mv;
        }
        return null;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView addUser(ModelAndView mv, String loginName, String password, String email) {
        Boolean isExist = userService.register(loginName, password, email);
        if (isExist) {
            mv.setViewName("register.jsp");
            mv.addObject("msg", "用户已存在");
            return mv;
        } else {
            mv.addObject("msg", "");
            mv.setViewName("login.jsp");
            return mv;
        }
    }

    @RequestMapping(value = "verifyUser", method = RequestMethod.POST)
    @ResponseBody
    public Object verifyUser(String loginName, HttpServletResponse response) throws IOException {
        Boolean isExist = userService.register(loginName, null, null);
        JsonResult jsonResult=new JsonResult();
        if (isExist) {
            jsonResult.setMsg("用户已存在");
           return jsonResult;
        } else {
            jsonResult.setMsg("");
            return  jsonResult;
        }

    }
}
