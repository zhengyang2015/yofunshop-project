package com.yofun.service;

import com.yofun.vo.OrderAll;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "yofunshoporder")
public interface DisplayOrderService {

    @RequestMapping(value = "/integrateInsertOrder", method = RequestMethod.POST)
    void insertOrder(@RequestBody OrderAll orderAll);
}
