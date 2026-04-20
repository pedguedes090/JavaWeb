package org.example.hnk24cntt2nguyendangduong001.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.hnk24cntt2nguyendangduong001")
public class WebConfig {

        @Bean
        public SpringResourceTemplateResolver resourceTemplateResolver(){
            SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
            springResourceTemplateResolver.setTemplateMode(TemplateMode.HTML);
            springResourceTemplateResolver.setPrefix("/WEB-INF/views/");
            springResourceTemplateResolver.setSuffix(".html");
            springResourceTemplateResolver.setCharacterEncoding("UTF-8");
            return springResourceTemplateResolver;
        }

        @Bean
        public SpringTemplateEngine springTemplateEngine(){
            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.setTemplateResolver(resourceTemplateResolver());
            return templateEngine;
        }

        @Bean
        public ThymeleafViewResolver resolver(){
            ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
            thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
            thymeleafViewResolver.setCharacterEncoding("UTF-8");
            return thymeleafViewResolver;
        }

        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        }

        @Bean
        public MultipartResolver multipartResolver(){
            return new StandardServletMultipartResolver();
        }
}
