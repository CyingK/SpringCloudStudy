package com.cying.service;

import com.cying.entities.ThreadBack;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FallbackService implements OrderService {

    @Value("${server.port}")
    private String port;

    public ThreadBack ok() {
        return new ThreadBack(port, Thread.currentThread().getName(), "对方已宕机 ≧ ﹏ ≦");
    }

    @Override
    public ThreadBack timeOut() {
        return new ThreadBack(port, Thread.currentThread().getName(), "对方已宕机 ≧ ﹏ ≦");
    }
}
