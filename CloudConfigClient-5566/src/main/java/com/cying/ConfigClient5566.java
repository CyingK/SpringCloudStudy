package com.cying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ConfigClient5566 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient5566.class, args);
    }

}
