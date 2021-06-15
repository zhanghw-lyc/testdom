package com.example.bdkj_website.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImgMappingConfig implements WebMvcConfigurer {

    @Value("${filePath}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String fileHead = "file:";
        registry.addResourceHandler("/**")
                .addResourceLocations(fileHead+filePath+"/");

    }



}
