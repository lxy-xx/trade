package com.safewind.controller;

import com.safewind.methods.CookieUse;
import com.safewind.model.User;
import com.safewind.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by zhh on 2018/6/2.
 */
@Controller
public class LoginController {

    @Autowired private UserService userService;

    @RequestMapping(value="login")
    public String login(Model model){
        Date date=new Date();
        long datetime=date.getTime();
        model.addAttribute("prefix",String.valueOf(datetime));
        return "login";
    }
    @RequestMapping(value="loginToHome")
    public String loginToHome(@Param("username") String username, @Param("password") String password, Model model, HttpServletResponse response
            , HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        User user=null;
        CookieUse cookieUse=new CookieUse();
        user=userService.longin(username,password,session.getAttribute("prefix").toString());
        if(null!=user) {
            cookieUse.saveCookie(user.getRealName(),user.getPassword());
            model.addAttribute("currentUser", user);

            return "MyCount";
        }else{
            model.addAttribute("errorInformation","用户名或密码错误！");
        return "login";}
    }

    @RequestMapping(value="loginToHome2")
    public String loginToHome2() {

        return "MyCount";

    }

}
