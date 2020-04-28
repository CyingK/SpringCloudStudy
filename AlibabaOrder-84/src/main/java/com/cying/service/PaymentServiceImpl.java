package com.cying.service;

import cn.hutool.core.util.IdUtil;
import com.cying.entities.CommonResult;
import com.cying.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> get(Long id) {
        return new CommonResult<Payment>(404, Thread.currentThread().getName(), new Payment(1L, IdUtil.fastSimpleUUID()));
    }
}
