package com.sun.didi.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public void add(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("redirect:/login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
