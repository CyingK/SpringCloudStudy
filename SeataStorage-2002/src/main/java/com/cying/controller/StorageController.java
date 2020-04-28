package com.cying.controller;

import com.cying.entities.CommonResult;
import com.cying.service.impl.StorageServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Resource
    private StorageServiceImpl service;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        service.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }

}
