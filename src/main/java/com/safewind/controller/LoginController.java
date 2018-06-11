package com.safewind.controller;

import com.safewind.methods.CookieUse;
import com.safewind.model.Money;
import com.safewind.model.User;
import com.safewind.service.MoneyService;
import com.safewind.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by zhh on 2018/6/2.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private MoneyService moneyService;

    @RequestMapping(value="login")
    public String login(HttpServletRequest request,Model model){
        Date date=new Date();
        long datetime=date.getTime();
        model.addAttribute("prefix",String.valueOf(datetime));
        request.getSession().setAttribute("prefix",String.valueOf(datetime));
        return "login";
    }
    @RequestMapping(value="loginToHome")
    public String loginToHome(@Param("username") String username, @Param("password") String password, Model model
            , HttpServletRequest request,HttpServletResponse response,int auto) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        User user=null;
        user=userService.longin(username,password,session.getAttribute("prefix").toString());
        Cookie cookie;
        if(null!=user) {
            if (auto==1) {
                CookieUse cookieUse = new CookieUse();
                cookie=cookieUse.saveCookie(user.getPhoneNumber(), user.getPassword());
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);
            }
            session.setAttribute("currentUser", user);
            return "redirect:myCount";
        }else{
            model.addAttribute("errorInformation","用户名或密码错误！");
            return "login";
        }
    }




    @RequestMapping(value="myCount")
    public String myCount(HttpSession session,Model model) {
        User user = (User) session.getAttribute("currentUser");
        String rate = moneyService.getInterestRates();
        Money money = moneyService.getMoneyNow(user.getId());
        model.addAttribute("rate",rate);
        model.addAttribute("user",user);
        model.addAttribute("money",money);
        return "myCount";

    }

}
