package com.klv.multitenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.klv.multitenant")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
