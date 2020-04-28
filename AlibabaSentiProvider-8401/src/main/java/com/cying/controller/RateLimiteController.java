package com.cying.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cying.entities.CommonResult;
import com.cying.handler.GlobalHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RateLimiteController {

    @GetMapping(value = "/byres")
    @SentinelResource(
            value = "byres",
            blockHandler = "byResHandler"
    )
    public CommonResult<String> byRes() {
        return new CommonResult<String>(200, Thread.currentThread().getName());
    }

    public CommonResult<String> byResHandler(BlockException e) {
        return new CommonResult<String>(200, Thread.currentThread().getName(), e.getClass().getCanonicalName());
    }

    @GetMapping(value = "/limite")
    @SentinelResource(
            value = "limite",
            blockHandlerClass = GlobalHandler.class,
            blockHandler = "m1"
    )
    public CommonResult limiteTest() {
        return new CommonResult(200, Thread.currentThread().getName(), "limiteTest");
    }

}
