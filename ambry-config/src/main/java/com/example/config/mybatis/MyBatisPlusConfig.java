package com.example.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.business.**.mapper")
public class MyBatisPlusConfig {
}
