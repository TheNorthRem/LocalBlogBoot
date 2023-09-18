package com.bupt.myblog.config;

import com.bupt.myblog.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class ImageMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + Utils.getParamSettings("imagePath"));
        log.info("image path load success, the path:" + Utils.getParamSettings("imagePath"));
    }
}
