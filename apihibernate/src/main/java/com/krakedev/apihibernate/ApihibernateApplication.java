package com.krakedev.apihibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.krakdev", "com.krakedev"})
@EnableJpaRepositories(basePackages = "com.krakdev.peliculas.repository")
@org.springframework.boot.persistence.autoconfigure.EntityScan(basePackages = "com.krakdev.peliculas.entidades")
public class ApihibernateApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApihibernateApplication.class, args);
    }
}