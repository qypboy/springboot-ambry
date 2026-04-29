package com.ambry.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.ambry.integration")
@MapperScan("com.ambry.business.mapper")
@SpringBootApplication(scanBasePackages = "com.ambry")
public class AmbryAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmbryAdminApplication.class, args);
    }
}
