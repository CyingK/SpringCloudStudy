package com.cying.controller;

import com.cying.entities.CommonResult;
import com.cying.entities.Payment;
import com.cying.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = service.create(payment);
        if (result > 0) {
            return new CommonResult(200, "Success, " + port, result);
        } else {
            return new CommonResult(444, "Failed, " + port, result);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = service.getPaymentById(id);
        if (result != null) {
            return new CommonResult<Payment>(200, "Success, " + port, result);
        } else {
            return new CommonResult<>(444, "Failed, " + port,null);
        }
    }

    @GetMapping(value = "/sleep")
    public String sleep() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sleep";
    }

}
