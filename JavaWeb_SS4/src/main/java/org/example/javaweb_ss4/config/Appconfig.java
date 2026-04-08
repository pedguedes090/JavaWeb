package org.example.javaweb_ss4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Đánh dấu lớp này là lớp cấu hình
@Configuration
// Mở chế độ Web MVC
@EnableWebMvc
// Chế độ quét bean để khởi tạo
@ComponentScan(basePackages = "org.example.javaweb_ss4")
public class Appconfig {
    // Cấu hình view
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // Set tiền tố
        viewResolver.setPrefix("/WEB-INF/views/");
        // Set hậu tố
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}