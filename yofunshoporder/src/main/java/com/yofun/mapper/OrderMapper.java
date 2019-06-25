package com.yofun.mapper;

import com.yofun.model.Order;
import com.yofun.vo.OrderVo;

import java.util.List;

public interface OrderMapper {
    void insertOrder(Order order);
    List<Order> queryOrderByVo(OrderVo orderVo);
    void updateOrderByUser(Order order);
    Order findOrderById(int id);
}
