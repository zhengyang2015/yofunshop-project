package com.yofun.controller;

import com.yofun.model.Order;
import com.yofun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/toInsertOrder", method = RequestMethod.GET)
    public String toInsertOrder() {
        return "orderinsert";
    }

    @RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
    public void insertOrder(Order order) {
        orderService.insertOrder(order);
    }
}
