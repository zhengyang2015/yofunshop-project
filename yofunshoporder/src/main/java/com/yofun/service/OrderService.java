package com.yofun.service;

import com.yofun.dao.OrderDao;
import com.yofun.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public void insertOrder(Order order) {
        LocalDateTime dateTime = LocalDateTime.now();
        String tradeNumber = UUID.randomUUID() + dateTime.toString();

        order.setCreateAt(dateTime);
        order.setTradeNumber(tradeNumber);
        order.setOrderStatus(0);
        order.setPaymentStatus(1);
        orderDao.insertOrder(order);
    }
}
