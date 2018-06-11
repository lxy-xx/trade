package com.safewind.methods;


import com.safewind.model.User;
import com.safewind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zhh on 2018/6/1.
 */
public class HandleInterceptor implements Filter {
    @Autowired private UserService userService ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        ServletContext sc = request.getSession().getServletContext();
        XmlWebApplicationContext cxt = (XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);

        if(cxt != null && cxt.getBean("userService") != null && userService == null)
            userService = (UserService) cxt.getBean("userService");

        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        CookieUse cookieUse = new CookieUse();
        Entryption entryption = new Entryption();
        Cookie cookie=null;
        if(cookies!=null)
          cookie = cookieUse.selectCookie(cookies);
        String[] UnAndPwd = new String[2];
        if (null != cookie)
            UnAndPwd = cookieUse.analizeCookie(cookie.getValue());
        Date date = new Date();
        long datetime = date.getTime();
        String username = UnAndPwd[0];
        String password = entryption.md5prefix(String.valueOf(datetime), UnAndPwd[1]);
        //数据库比较，加入session，跳转页面
        User user = userService.longin(username, password, String.valueOf(datetime));
        if (null != user) {
            session.setAttribute("currentUser", user);
            response.sendRedirect("myCount");
        }else {
            filterChain.doFilter(request,response);
        }


    }

    @Override
    public void destroy() {

    }
}
