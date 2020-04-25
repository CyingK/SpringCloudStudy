package com.cying.controller;

import com.cying.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate template;

    @Value("${service-url.nacos-user-service}")
    private String BASE_URL;

    @GetMapping(value = "/cst/ali/get/{id}")
    public CommonResult get(@PathVariable("id") String id) {
        CommonResult result = template.getForObject(BASE_URL + "/ali/get", CommonResult.class, id);
        result.setData(id);
        return result;
    }

}
