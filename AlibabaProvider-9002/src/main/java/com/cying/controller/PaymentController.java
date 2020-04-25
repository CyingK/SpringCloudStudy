package com.cying.controller;

import cn.hutool.core.util.IdUtil;
import com.cying.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/ali/get")
    public CommonResult get() {
        return new CommonResult(200, port, IdUtil.fastSimpleUUID());
    }

}
