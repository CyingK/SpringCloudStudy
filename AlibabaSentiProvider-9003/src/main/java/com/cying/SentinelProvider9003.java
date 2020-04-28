package com.cying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelProvider9003 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelProvider9003.class, args);
    }

}
