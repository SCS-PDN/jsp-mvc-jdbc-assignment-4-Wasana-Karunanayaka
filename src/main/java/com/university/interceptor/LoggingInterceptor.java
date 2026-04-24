package com.university.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

// Intercepts every request and logs it to the console
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // Log the request method (GET/POST) and the URL being accessed
        System.out.println("[LOG] " + request.getMethod() +
                           " request to: " + request.getRequestURI());

        // Return true to allow the request to continue
        return true;
    }
}