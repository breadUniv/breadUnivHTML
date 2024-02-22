package com.firebird.breaduniv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${img.macurl}") /* mac용 이미지 출력 url */
    private String macPath; /* mac용 이미지 출력 변수 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/");

        // 프로필 업데이트 이미지
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:///c:/thymeleaf-springboot/upload/");

         /* mac용 이미지 출력 */
        // 프로필 업데이트 이미지
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///" + macPath);
    }
}