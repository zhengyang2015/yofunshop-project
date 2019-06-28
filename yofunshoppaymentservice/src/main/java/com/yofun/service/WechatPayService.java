package com.yofun.service;

import org.springframework.stereotype.Service;

@Service
public class WechatPayService implements PaymentService {

    public int payWithAmount(String tradeNumber, double amount) {
        System.out.println("WechatPay success");
        return 1;
    }
}
