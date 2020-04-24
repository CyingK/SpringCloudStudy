package com.cying.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cying.entities.CommonResult;
import com.cying.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    public String send() {
        String serial = IdUtil.fastSimpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        return null;
    }
}
