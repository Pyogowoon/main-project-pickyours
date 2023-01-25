package com.pyo.yourspick.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.path}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);



        registry
                .addResourceHandler("/upload/**")
                //jsp 페이지에서 /upload/** 이런 주소 패턴이 나오면 발동
                .addResourceLocations("file:///" + uploadFolder)
                //     file:///C:/imagesaver/springbootwork/upload/ 이렇게 적힌다는소리
                .setCachePeriod(60*10*6) // 1시간동안 캐싱
                .resourceChain(true)
                .addResolver(new PathResourceResolver()); // 붙여줘야 발동
    }
}



