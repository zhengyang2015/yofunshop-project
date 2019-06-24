package com.yofun.dao;

import com.yofun.mapper.OrderMapper;
import com.yofun.model.Order;
import com.yofun.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    public List<Order> queryOrderByVo(OrderVo orderVo) {
        return orderMapper.queryOrderByVo(orderVo);
    }
}
