package com.cying.service.impl;

import com.cying.dao.OrderDao;
import com.cying.domain.Order;
import com.cying.service.AccountService;
import com.cying.service.OrderService;
import com.cying.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao dao;

    @Resource
    private AccountService account;

    @Resource
    private StorageService storage;

    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("创建订单");
        dao.create(order);
        log.info("创建完成");
        log.info("删减库存");
        storage.decrease(order.getProductId(), order.getCount());
        log.info("删减成功");
        log.info("扣除余额");
        account.decrease(order.getUserId(), order.getMoney());
        log.info("扣除成功");
        log.info("修改订单状态");
        dao.update(order.getUserId(), 0);
        log.info("修改订单结束");
    }
}
