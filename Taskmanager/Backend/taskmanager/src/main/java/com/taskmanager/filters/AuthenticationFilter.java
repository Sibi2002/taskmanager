package com.taskmanager.filters;

import com.taskmanager.service.SessionService;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class AuthenticationFilter implements Filter {
    public  static String ORIGIN="Access-Control-Allow-Origin";
    public  static String CREDENTIALS="Access-Control-Allow-Credentials";
    public  static String METHODS="Access-Control-Allow-Methods";
    public  static String HEADERS ="Access-Control-Allow-Headers";
    public static String PREFLIGHT="OPTIONS";
    SessionService sessionService;

    public AuthenticationFilter(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if ("username".equals(ck.getName())) {
                    UUID id=UUID.fromString(ck.getValue()) ;
                   if( sessionService.getAuth(id)!=null){
                       chain.doFilter(request, response);
                   }
                }
            }
        }
        else if(PREFLIGHT.equals(req.getMethod())) {
            response.reset();
            System.out.println("cookies did not match");
            HttpServletResponse res = (HttpServletResponse) response;
            res.setHeader(ORIGIN, "http://localhost:3000");
            res.setHeader(CREDENTIALS, "true");
            res.setHeader(METHODS, "POST,GET");
            res.setHeader(HEADERS,"content-type");
        }
    }
}