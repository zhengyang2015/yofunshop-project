package com.yofun.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class WechatPayService implements PaymentService {

    Logger logger = Logger.getLogger(WechatPayService.class);

    public int payWithAmount(String tradeNumber, double amount) {
        logger.info("WechatPay success");
        return 1;
    }
}
