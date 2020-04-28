package com.cying.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cying.entities.CommonResult;

public class GlobalHandler {

    public static CommonResult m1(BlockException e) {
        return new CommonResult(200, Thread.currentThread().getName(), e.getClass().getCanonicalName());
    }

    public static CommonResult m2(BlockException e) {
        return new CommonResult(200, Thread.currentThread().getName(), e.getClass().getCanonicalName());
    }

}
