package com.cying.dao;

import com.cying.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") int status);

}
