package com.cying.springcloud;

import com.cying.entities.Payment;
import com.cying.mapper.PaymentDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TMapper {

    @Resource
    PaymentDao dao;

    @Test
    public void main() {
        Payment payment = dao.getPaymentById(1L);
        log.info("-----" + payment.toString());
    }

}
