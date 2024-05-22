package org.example.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {
    @Bean
    public MyCustomViewResolver viewResolver() {
        MyCustomViewResolver viewResolver = new MyCustomViewResolver();
        viewResolver.setOrder(0);
        return viewResolver;
    }
}
