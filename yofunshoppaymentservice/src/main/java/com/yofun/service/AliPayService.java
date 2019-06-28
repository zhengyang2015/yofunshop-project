package com.yofun.service;

import org.springframework.stereotype.Service;

@Service
public class AliPayService implements PaymentService {

    public int payWithAmount(String tradeNumber, double amount) {
        System.out.println("AliPay success");
        return 1;
    }
}
