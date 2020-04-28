package com.cying.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cying.entities.CommonResult;
import com.cying.entities.Payment;
import com.cying.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Value("${config.baseurl}")
    private String URL;

    @Resource
    private RestTemplate template;

    @Resource
    private PaymentService service;

    @GetMapping(value = "/cst/getf/{id}")
    public CommonResult<Payment> getFeign(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping(value = "/cst/get/{id}")
    @SentinelResource(
            value = "fallback",
            fallback = "fallbackHandler",
            blockHandler = "blockHandler"
    )
    public CommonResult fallback(@PathVariable("id") Long id) {

        CommonResult result = template.getForObject(URL + "/get/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (result ==null || result.getData() == null) {
            throw new NullPointerException("空指针异常");
        }

        return result;

    }

    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException e) {
        return new CommonResult(404, "block_Handler" + e.getMessage(), new Payment(id, null));
    }

    public CommonResult fallbackHandler(@PathVariable("id") Long id, Throwable e) {
        return new CommonResult(404, "fallback_Handler" + e.getMessage(), new Payment(id, null));
    }

}
