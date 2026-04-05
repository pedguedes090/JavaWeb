package org.example.javaweb_ss1;

import org.example.javaweb_ss1.config.Appconfig;
import org.example.javaweb_ss1.model.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);

        SystemConfig config = context.getBean(SystemConfig.class);

        System.out.println("=== THONG TIN CAU HINH ===");
        System.out.println("Ten chi nhanh: " + config.getBranchName());
        System.out.println("Gio mo cua: " + config.getOpeningHour());
    }
}
