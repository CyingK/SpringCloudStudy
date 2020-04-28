package com.cying.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.cying.dao"})
public class MyBatisConfig {
}
