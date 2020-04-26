package com.cying.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cying.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @GetMapping(value = "/test1")
    public CommonResult test1() {
        return new CommonResult(200, "Test1", null);
    }

    @GetMapping(value = "/test2")
    public CommonResult test2() {
        return new CommonResult(200, "Test2", null);
    }

    @GetMapping(value = "/test3")
    public CommonResult test3() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CommonResult(200, "Test3", null);
    }

    @GetMapping(value = "/hotkey")
    @SentinelResource(
            value = "hotkey",
            blockHandler = "hotkeyHandler"
    )
    public CommonResult<String> hotKey(
            @RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p2", required = false) String p2
    ) {
        return new CommonResult<String>(200, "p1: " + p1 + ", p2: " + p2);
    }

    public CommonResult<String> hotkeyHandler(String p1, String p2, BlockException e) {
        return new CommonResult<String>(200, "p1: " + p1 + ", p2: " + p2, e.getMessage());
    }

}
