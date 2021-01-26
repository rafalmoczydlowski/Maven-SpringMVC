package com.rafinha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.rafinha.web")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver resolver() {
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setPrefix("/web/");
        irvr.setSuffix(".jsp");
        irvr.setExposeContextBeansAsAttributes(true);
        return irvr;
    }

    public void configureDefaultServletHandling (
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
