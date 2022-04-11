package com.mints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MintsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MintsApplication.class, args);
    }
}
