package com.cying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Order80 {

    public static void main(String[] args) {
        SpringApplication.run(Order80.class, args);
    }

}
