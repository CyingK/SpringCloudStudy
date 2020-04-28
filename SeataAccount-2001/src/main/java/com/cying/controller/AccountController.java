package com.cying.controller;

import com.cying.entities.CommonResult;
import com.cying.service.impl.AccountServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

    @Resource
    private AccountServiceImpl service;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        service.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }

}
