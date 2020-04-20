package com.cying.controller;

import com.cying.entities.ThreadBack;
import com.cying.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService service;

    @GetMapping(value = "/ok")
    public ThreadBack ok() {
        return service.ok();
    }

    @GetMapping(value = "/timeout")
    public ThreadBack timeOut() {
        return service.timeOut();
    }

    @GetMapping(value = "/circuit/{id}")
    public ThreadBack circuitBreaker(@PathVariable("id") Long id) {
        return service.circuitBreaker(id);
    }
}
