package com.cying.service;

import com.cying.entities.ThreadBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(
        value = "HYSTRIX-PAYMENT",
        fallback = FallbackService.class
)
public interface OrderService {

    @GetMapping(value = "/ok")
    public ThreadBack ok();

    @GetMapping(value = "/timeout")
    public ThreadBack timeOut();

}
