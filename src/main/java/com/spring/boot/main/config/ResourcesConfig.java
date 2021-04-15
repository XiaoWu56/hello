//package com.spring.boot.main.config;
//
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//public class ResourcesConfig extends WebMvcConfigurationSupport {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//       registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//       registry.addResourceHandler("/jportal-jsccbsite/**").addResourceLocations("classpath:/jportal-jsccbsite/");
//       registry.addResourceHandler("/seat/**").addResourceLocations("classpath:/static/seat/");
//       registry.addResourceHandler("/stranded/**").addResourceLocations("classpath:/static/stranded/");
//    }
//}