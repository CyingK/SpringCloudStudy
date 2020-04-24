package com.cying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Client8803 {

    public static void main(String[] args) {
        SpringApplication.run(Client8803.class, args);
    }

}
