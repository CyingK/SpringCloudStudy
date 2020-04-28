package com.cying.service;

import com.cying.entities.CommonResult;
import com.cying.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "Sentinel-Provider", fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id);

}
