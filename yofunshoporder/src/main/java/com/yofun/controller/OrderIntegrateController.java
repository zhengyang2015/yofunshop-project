package com.yofun.controller;

import com.yofun.model.Order;
import com.yofun.model.OrderDetails;
import com.yofun.service.OrderDetailsService;
import com.yofun.service.OrderService;
import com.yofun.vo.OrderAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@EnableEurekaClient
@RestController
public class OrderIntegrateController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping(value = "/integrateInsertOrder", method = RequestMethod.POST)
    public void insertOrder(@RequestBody OrderAll orderAll) {
        Order order = orderAll.getOrder();
        orderService.insertOrder(order);

        OrderDetails orderDetails = orderAll.getOrderDetails();
        // order id and create time can only be get after order persistence
        orderDetails.setOrderId(order.getId());
        orderDetails.setCreateAt(order.getCreateAt());
        orderDetailsService.insertOrderDetails(orderDetails);
    }

    @RequestMapping(value = "/integrateFindOrderById", method = RequestMethod.GET)
    public Order findOrderById(@RequestParam(value = "id") int id) {
        return orderService.findOrderById(id);
    }

    @RequestMapping(value = "/integrateUpdateOrderById", method = RequestMethod.POST)
    public void updateOrderById(@RequestParam(value = "id") int id, @RequestParam(value = "paymentType") int paymentType, @RequestParam(value = "paymentStatus") int paymentStatus) {
        orderService.updateOrderById(id, paymentType, paymentStatus);
    }
}
