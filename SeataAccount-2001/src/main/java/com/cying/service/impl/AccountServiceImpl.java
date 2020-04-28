package com.cying.service.impl;

import com.cying.dao.AccountDao;
import com.cying.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao account;

    public void decrease(Long userId, BigDecimal money) {
        account.decrease(userId, money);
    }

}
