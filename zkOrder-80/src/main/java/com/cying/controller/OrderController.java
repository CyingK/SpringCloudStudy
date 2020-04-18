package com.cying.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/cst/payment")
public class OrderController {

    @Resource
    RestTemplate template;

    @RequestMapping(value = "/zk")
    public String order() {
        return template.getForObject("http://cying.com:8003/payment/zk", String.class);
    }

}
