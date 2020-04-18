package com.cying.service;

import com.cying.entities.ThreadBack;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    @Value("${server.port}")
    private String port;

    public ThreadBack ok() {
        return new ThreadBack(port, Thread.currentThread().getName(), "运行了 0 秒得到结果 (●'◡'●)");
    }

    @HystrixCommand(
            fallbackMethod = "timeOutHandler",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            }
    )
    public ThreadBack timeOut() {
        int TIME = 5;
        Random random = new Random();
        if (random.nextInt()%2==0) {
            TIME = 0;
        }
        try {
            TimeUnit.SECONDS.sleep(TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ThreadBack(port, Thread.currentThread().getName(), "运行了 " + TIME + " 秒得到结果 (●'◡'●)");
    }

    public ThreadBack timeOutHandler() {
        return new ThreadBack(port, Thread.currentThread().getName(), "超时了 /(ㄒoㄒ)/~~");
    }

}

