package com.safewind.methods;

import javax.servlet.http.Cookie;

/**
 * Created by zhh on 2018/6/1.
 */
public class CookieUse {
    public Cookie saveCookie(String username, String password){
        Entryption entryption=new Entryption();
        int unLength=username.length();
        String UnAndPwd="";
        if(0==unLength/10)//0为十位数以下的用户名，1为十位数以上的用户名
            UnAndPwd=String.valueOf(0)+String.valueOf(unLength)+username+entryption.md5password(password);
        else if(1==unLength/10)
            UnAndPwd=String.valueOf(1)+String.valueOf(unLength)+username+entryption.md5password(password);
        Cookie cookie=new Cookie("UnAndPwd",UnAndPwd);
        cookie.setMaxAge(60*60*48);//2天
        return cookie;
    }
    public Cookie selectCookie(Cookie[] cookies){
        for(Cookie cookie : cookies)
            if("UnAndPwd".equals(cookie.getName()))
                return cookie;
        return null;
    }
    public String[] analizeCookie(String cookieInformation){
        String tag=cookieInformation.substring(0,1);
        int length=0;
        if("0".equals(tag))
            length=1;
        else if("1".equals(tag))
            length=2;
        int unLength=Integer.parseInt(cookieInformation.substring(1,1+length++));
        String [] UnAndPwd = new String[2];
        UnAndPwd[0]=cookieInformation.substring(length,length+unLength);
        UnAndPwd[1]=cookieInformation.substring(length+unLength);
        return UnAndPwd;
    }
}
