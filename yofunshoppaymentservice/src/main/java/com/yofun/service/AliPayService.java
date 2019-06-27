package com.yofun.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AliPayService implements PaymentService {

    Logger logger = Logger.getLogger(AliPayService.class);

    public int payWithAmount(String tradeNumber, double amount) {
        logger.info("AliPay success");
        return 1;
    }
}
