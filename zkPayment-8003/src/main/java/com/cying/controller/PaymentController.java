package com.cying.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/zk")
    public String paymentZK() {
        return "{\"port\":\"" + port + ", " + UUID.randomUUID() + "\"}";
    }

}
