package com.spring.boot.main.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableAutoConfiguration
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	
        // 访问http://localhost:8080/static/*** 都会跳转到classpath:/static/下去找，即resources/static/
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}