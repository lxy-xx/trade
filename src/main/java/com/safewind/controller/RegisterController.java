package com.safewind.controller;

import com.safewind.dao.UserDao;
import com.safewind.model.User;
import com.safewind.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by qt on 2018/6/1.
 */
@Controller
public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired private UserDao userDao;
    @RequestMapping("register")
    @ResponseBody
    public String register(User user){
        if(userService.register(user))
            return "{\"msg\":\"1\"}";//注册成功网页
        return "{\"msg\":\"-1\"}";//失败页面
    }
    @RequestMapping("rechecked")//查询是否存在这个
    @ResponseBody
    public String recheked(@Param("username") String username, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        boolean bl=userService.recheck(username);
        if(bl)
            return "{\"msg\":\"1\"}";
        return "{\"msg\":\"-1\"}";
    }
}
