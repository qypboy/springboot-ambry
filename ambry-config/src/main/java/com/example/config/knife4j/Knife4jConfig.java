package com.example.config.knife4j;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI mallOpenApi() {
        return new OpenAPI().info(new Info()
                .title("门窗橱柜定制商城系统")
                .description("后端 REST API，前端独立部署")
                .version("1.0.0"));
    }
}
