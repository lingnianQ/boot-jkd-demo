package tech.aistar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(scanBasePackages = {"tech.aistar.controller","tech.aistar.service.impl"})
@MapperScan(basePackages = "tech.aistar.mapper")
public class BootJkdDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootJkdDemoApplication.class, args);
    }

}