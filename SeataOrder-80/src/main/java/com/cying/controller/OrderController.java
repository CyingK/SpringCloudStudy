package com.cying.controller;

import com.cying.domain.Order;
import com.cying.entities.CommonResult;
import com.cying.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200, "OK", Thread.currentThread().getName());
    }
}

