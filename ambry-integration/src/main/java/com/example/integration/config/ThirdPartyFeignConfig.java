package com.example.integration.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdPartyFeignConfig {

    @Bean
    public RequestInterceptor feignAuthRequestInterceptor() {
        return template -> template.header("X-System-Code", "springboot-ambry");
    }
}
