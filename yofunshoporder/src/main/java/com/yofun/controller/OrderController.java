package com.yofun.controller;

import com.yofun.model.Order;
import com.yofun.service.OrderService;
import com.yofun.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @RequestMapping(value = "/queryOrderByVo", method = RequestMethod.GET)
    public String queryOrderByVo(Model model) {
        OrderVo orderVo = new OrderVo();
        List<Order> orders = orderService.queryOrderByVo(orderVo);
        model.addAttribute("orders", orders);
        return "orders";
    }
}
