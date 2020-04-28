package com.cying.controller;

import cn.hutool.core.util.IdUtil;
import com.cying.entities.CommonResult;
import com.cying.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    private static Map<Long, Payment> map = new HashMap<>();

    @Value("${server.port}")
    private String port;

    static {
        map.put(1L, new Payment(1L, IdUtil.fastSimpleUUID()));
        map.put(2L, new Payment(2L, IdUtil.fastSimpleUUID()));
        map.put(3L, new Payment(3L, IdUtil.fastSimpleUUID()));
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        return new CommonResult<>(200, port, map.get(id));
    }

}
