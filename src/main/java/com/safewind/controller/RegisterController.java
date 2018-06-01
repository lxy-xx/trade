package com.safewind.controller;

import com.safewind.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qt on 2018/6/1.
 */
@Controller
public class RegisterController {
    @RequestMapping("register")
    public String register(User user){
        return "";
    }
}
