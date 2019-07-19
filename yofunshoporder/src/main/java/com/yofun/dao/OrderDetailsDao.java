package com.yofun.dao;

import com.yofun.mapper.OrderDetailsMapper;
import com.yofun.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsDao {
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    public void insertOrderDetails(OrderDetails orderDetails) {
        orderDetailsMapper.insertOrderDetails(orderDetails);
    }
}
