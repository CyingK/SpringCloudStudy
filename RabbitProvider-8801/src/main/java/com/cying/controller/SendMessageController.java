package com.cying.controller;

import com.cying.entities.CommonResult;
import com.cying.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private MessageProviderImpl message;

    @GetMapping(value = "/sendmsg")
    public CommonResult sendMessage() {
        return new CommonResult(200, message.send(), null);
    }

}
