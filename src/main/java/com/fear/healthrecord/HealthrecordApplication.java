package com.fear.healthrecord;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan(basePackages = { "com.fear.healthrecord" })
@MapperScan("com.fear.healthrecord.mapper")


public class HealthrecordApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HealthrecordApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HealthrecordApplication.class);
    }
}
