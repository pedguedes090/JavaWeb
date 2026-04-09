package com.restaurant.bai1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    // Inject ApplicationContext vào để Thymeleaf có thể resolve các resource của Spring
    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /* 1. Bean này chịu trách nhiệm tìm kiếm các file HTML dựa trên prefix và suffix */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(this.applicationContext);

        // Đã sửa: Trỏ đúng vào thư mục templates và THÊM dấu '/' ở cuối
        resolver.setPrefix("/WEB-INF/templates/");

        // Đã sửa: Thymeleaf sử dụng HTML
        resolver.setSuffix(".html");

        // Thiết lập chuẩn
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheable(false); // Nên set false khi code/debug để tránh lưu cache giao diện
        return resolver;
    }

    /* 2. Bean này chịu trách nhiệm biên dịch các biểu thức Thymeleaf thành mã HTML */
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.setEnableSpringELCompiler(true); // Tối ưu hiệu suất biểu thức Spring EL
        return engine;
    }

    /* 3. Bean này thay thế InternalResourceViewResolver của JSP, giúp Spring MVC sử dụng Thymeleaf */
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1); // Ưu tiên view resolver này xử lý trước
        return resolver;
    }
}