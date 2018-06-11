package com.safewind.methods;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhh on 2018/6/1.
 */
public class CookieUse {
    public Cookie saveCookie(String phoneNum, String password){
        String UnAndPwd="";
        UnAndPwd=phoneNum+password;
        Cookie cookie=new Cookie("UnAndPwd",UnAndPwd);
        System.out.println(UnAndPwd);
        return cookie;
    }
    public Cookie selectCookie(Cookie[] cookies){
        for(Cookie cookie : cookies){
            if("UnAndPwd".equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
    public String[] analizeCookie(String cookieInformation){
        String [] UnAndPwd = new String[2];
        UnAndPwd[0]=cookieInformation.substring(0,11);
        UnAndPwd[1]=cookieInformation.substring(11);
        System.out.println(UnAndPwd[0]);
        System.out.println(UnAndPwd[1]);
        return UnAndPwd;
    }
}
