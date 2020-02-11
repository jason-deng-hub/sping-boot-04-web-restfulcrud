package com.atguigu.spingboot.config;

import com.atguigu.spingboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@Configuration
public class MyServerConfig {

    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/myServlet ");
        return servletServletRegistrationBean;
    }

}
