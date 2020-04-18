package com.cying.controller;

import com.cying.entities.CommonResult;
import com.cying.entities.Payment;
import com.cying.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/cst/payment")
public class OrderController {

    @Resource
    private PaymentService service;

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return service.getPaymentById(id);
    }

    @GetMapping(value = "/sleep")
    public String sleep() {
        return service.sleep();
    }

}
