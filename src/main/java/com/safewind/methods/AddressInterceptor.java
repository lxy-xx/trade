package com.safewind.methods;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhh on 2018/6/2.
 */
public class AddressInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String referer = request.getHeader("Referer");
        System.out.println(referer);
        //两个非法链接
        if (referer==null) {
            response.sendRedirect("index.jsp");
            return false;
        }
        if(!referer.startsWith("http://localhost:8080/RequestAndResponse")){
            response.sendRedirect("index.jsp");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
