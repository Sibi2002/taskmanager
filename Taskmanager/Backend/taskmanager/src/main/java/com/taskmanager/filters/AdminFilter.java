package com.taskmanager.filters;

import com.taskmanager.service.SessionService;
import lombok.AllArgsConstructor;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor
public class AdminFilter implements Filter {
    SessionService sessionService;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                if ("username".equals(ck.getName())) {
                    UUID id=UUID.fromString(ck.getValue()) ;
                    if( sessionService.getAuth(id)!=null && sessionService.getAuth(id).getRole_id()==1){
                        chain.doFilter(request, response);
                    }
                }
            }
        }
    }
}
