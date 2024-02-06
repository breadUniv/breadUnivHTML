package com.firebird.breaduniv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/");

        // 이미지 불러올 수 있도록 세팅
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:///c:/thymeleaf-springboot/upload/");
//
//        registry.addResourceHandler("/thumbPath/**")
//                .addResourceLocations("file:///c:/thymeleaf-springboot/img/upload/thumbnail/");
//        registry.addResourceHandler("/imagePath/**")
//                .addResourceLocations("file:///c:/thymeleaf-springboot/img/upload/original/");

    }
}