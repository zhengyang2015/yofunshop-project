package com.yofun.service;

import com.yofun.dao.OrderDetailsDao;
import com.yofun.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsDao orderDetailsDao;

    public void insertOrderDetails(OrderDetails orderDetails) {
        orderDetailsDao.insertOrderDetails(orderDetails);
    }
}
