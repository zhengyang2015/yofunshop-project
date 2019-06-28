package com.yofun.service;

import org.springframework.stereotype.Service;

@Service
public class CreditCardPayService implements PaymentService {

    public int payWithAmount(String tradeNumber, double amount) {
        System.out.println("CreditCardPay success");
        return 1;
    }
}
