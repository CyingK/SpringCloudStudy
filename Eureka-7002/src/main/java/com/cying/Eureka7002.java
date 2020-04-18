package com.cying;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@Slf4j
@EnableEurekaServer
public class Eureka7002 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7002.class, args);
    }

}
