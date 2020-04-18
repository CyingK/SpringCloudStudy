package com.cying.controller;

import com.cying.entities.ThreadBack;
import com.cying.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@RequestMapping(value = "/cst")
@DefaultProperties(defaultFallback = "globalHandler")
public class OrderController {

    @Resource
    private OrderService service;

    @Value("${server.port}")
    private String port;

    @HystrixCommand
    @GetMapping(value = "/ok")
    public ThreadBack ok(){
        Random random = new Random();
        if (random.nextInt()%2==0) {
            int a = 10/0;
        }
        return service.ok();
    }

    @HystrixCommand(
            fallbackMethod = "timeOutHandler",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            }
    )
    @GetMapping(value = "/timeout")
    public ThreadBack timeOut() {
        return service.timeOut();
    }

    public ThreadBack timeOutHandler() {
        return new ThreadBack(port, Thread.currentThread().getName(), "超时了 /(ㄒoㄒ)/~~");
    }

    public ThreadBack globalHandler() {
        return new ThreadBack(port, Thread.currentThread().getName(), "运行时崩了个错 ~~>_<~~");
    }

}
