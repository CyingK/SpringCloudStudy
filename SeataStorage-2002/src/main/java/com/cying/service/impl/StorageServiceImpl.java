package com.cying.service.impl;

import com.cying.dao.StorageDao;
import com.cying.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storage;

    public void decrease(Long productId, Integer count) {
        storage.decrease(productId, count);
    }
}
