package com.yofun.service;

import com.yofun.model.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "yofunshoporder")
public interface OrderService {

    @RequestMapping(value = "/integrateFindOrderById", method = RequestMethod.GET)
    Order findOrderById(@RequestParam(value = "id") int id);

    @RequestMapping(value = "/integrateUpdateOrderById", method = RequestMethod.POST)
    void updateOrderById(@RequestParam(value = "id") int id, @RequestParam(value = "paymentType") int paymentType, @RequestParam(value = "paymentStatus") int paymentStatus);
}
