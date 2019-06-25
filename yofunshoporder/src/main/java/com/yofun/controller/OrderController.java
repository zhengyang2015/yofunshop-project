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

    @RequestMapping(value = "/toUpdateOrderByUser", method = RequestMethod.GET)
    public String toUpdateOrderByUser(int id, Model model) {
        Order order = orderService.findOrderById(id);
        if(order == null) {
            throw new RuntimeException("No order found by id : " + id);
        }

        model.addAttribute("order", order);
        return "orderupdate";
    }

    @RequestMapping(value = "/updateOrderByUser", method = RequestMethod.POST)
    public void updateOrderByUser(int id, String receiverName, String receiverTelephone, String receiverAddress) {
        orderService.updateOrderByUser(id, receiverName, receiverTelephone, receiverAddress);
    }

    @RequestMapping(value = "/findOrderById", method = RequestMethod.GET)
    public String findOrderById(int id, Model model) {
        Order order = orderService.findOrderById(id);
        if(order == null) {
            throw new RuntimeException("No order found by id : " + id);
        }

        model.addAttribute("order", order);
        return "orderview";
    }
}
