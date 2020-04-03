package com.athul.togglz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.athul.common")
public class TogglzFileBasedApplication {

    public static void main(String[] args) {
        SpringApplication.run(TogglzFileBasedApplication.class, args);
    }
}
