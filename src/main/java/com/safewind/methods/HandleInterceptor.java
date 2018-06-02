package com.safewind.methods;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zhh on 2018/6/1.
 */
public class HandleInterceptor implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse) servletResponse;
        Cookie[] cookies =request.getCookies();
        HttpSession session =request.getSession();
        CookieUse cookieUse = new CookieUse();
        Entryption entryption=new Entryption();
        Cookie cookie=cookieUse.selectCookie(cookies);
        String[] UnAndPwd=new String[2];
        if(null!=cookie)
            UnAndPwd=cookieUse.analizeCookie(cookie.getValue());
        String username=UnAndPwd[0];
        String password=entryption.md5prefix(new TimeSeed().getCurrentTime(),UnAndPwd[1]);
        //数据库比较，加入session，跳转页面



        // Filter 只是链式处理，请求依然转发到目的地址。
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
