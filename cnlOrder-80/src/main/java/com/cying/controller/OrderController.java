package com.cying.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cst/payment")
public class OrderController {

    private static final String DEFAULT_URL = "http://cying.com:8004/payment";

    @Resource
    RestTemplate template;

    @RequestMapping(value = "/cnl")
    public String order() {
        return template.getForObject(DEFAULT_URL + "/cnl", String.class);
    }

}
