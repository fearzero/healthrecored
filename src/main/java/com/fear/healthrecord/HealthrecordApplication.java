package com.fear.healthrecord;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = { "com.fear.healthrecord" })
@MapperScan("com.fear.healthrecord.mapper")


public class HealthrecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthrecordApplication.class, args);
    }

}
