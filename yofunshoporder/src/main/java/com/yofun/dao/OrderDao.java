package com.yofun.dao;

import com.yofun.mapper.OrderMapper;
import com.yofun.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }
}
