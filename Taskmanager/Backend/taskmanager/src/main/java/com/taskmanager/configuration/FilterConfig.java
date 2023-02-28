package com.taskmanager.configuration;

import com.taskmanager.filters.AdminFilter;
import com.taskmanager.filters.AuthenticationFilter;
import com.taskmanager.repository.SessionRepository;
import com.taskmanager.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Autowired
    SessionService sessionService;
    @Bean
    public FilterRegistrationBean someFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationFilter(sessionService));
        registration.addUrlPatterns("/api/*");
        registration.setName("AuthenticationFilter");
        registration.setOrder(1);
        return registration;
    }
    @Bean
    public FilterRegistrationBean Admin() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AdminFilter(sessionService));
        registration.addUrlPatterns("/api/admin/*");
        registration.setName("AuthenticationFilter");
        registration.setOrder(1);
        return registration;
    }
}
