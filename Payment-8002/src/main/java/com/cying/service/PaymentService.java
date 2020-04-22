package com.cying.service;

import com.cying.entities.Payment;
import com.cying.mapper.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService{

    @Resource
    public PaymentDao dao;

    public int create(Payment payment) {
        System.out.println(dao);
        return dao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        System.out.println(dao);
        return dao.getPaymentById(id);
    }
}
