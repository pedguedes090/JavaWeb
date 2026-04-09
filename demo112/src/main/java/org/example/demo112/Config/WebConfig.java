package org.example.demo112.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.example.demo112")
public class WebConfig {
    @Bean
    public SpringResourceTemplateResolver Reosolver(){
            SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
            resolver.setPrefix("classpath:/templates/");
            resolver.setSuffix(".html");
            resolver.setTemplateMode("HTML5");
            return resolver;
        }
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(Reosolver());
        return engine;
    }
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

}
