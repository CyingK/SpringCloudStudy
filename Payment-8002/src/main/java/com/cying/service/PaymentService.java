package com.cying.service;

import com.cying.entities.Payment;
import com.cying.mapper.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService{

    @Resource
    private PaymentDao dao;

    public int create(Payment payment) {
        return dao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return dao.getPaymentById(id);
    }
}
