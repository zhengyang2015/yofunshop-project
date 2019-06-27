package com.yofun.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CreditCardPayService implements PaymentService {

    Logger logger = Logger.getLogger(CreditCardPayService.class);

    public int payWithAmount(String tradeNumber, double amount) {
        logger.info("CreditCardPay success");
        return 1;
    }
}
