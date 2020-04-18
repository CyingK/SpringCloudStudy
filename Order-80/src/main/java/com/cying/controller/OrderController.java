package com.cying.controller;

import com.cying.entities.CommonResult;
import com.cying.entities.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private static String DEFAULT_URL = "http://Payment/payment";

    @Resource
    RestTemplate template;

    @GetMapping(value = "/cst/payment/create")
    public CommonResult create(Payment payment) {
        return template.postForObject(DEFAULT_URL + "/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/cst/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        return template.getForObject(DEFAULT_URL + "/get/" + id, CommonResult.class);
    }

}