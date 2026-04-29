package com.example.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.example.integration")
@SpringBootApplication(scanBasePackages = "com.example")
public class AmbryAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmbryAdminApplication.class, args);
    }
}
