package com.dailycodebuffer.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {
    @Override
 public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
     configurer.favorParameter(true)
             .parameterName("mediaType")

             .defaultContentType(MediaType.APPLICATION_JSON)
             .mediaType("xml",MediaType.APPLICATION_XML)
             .mediaType("Json",MediaType.APPLICATION_JSON);
    }
}
