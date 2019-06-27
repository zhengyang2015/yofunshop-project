package com.yofun.controller;

import com.yofun.service.AliPayService;
import com.yofun.service.CreditCardPayService;
import com.yofun.service.WechatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {

    @Autowired
    private WechatPayService wechatPayService;

    @Autowired
    private AliPayService aliPayService;

    @Autowired
    private CreditCardPayService creditCardPayService;


    @RequestMapping(value = "/payWithAmount")
    public int payWithAmount(String payType, String tradeNumber, double amount) {

        int paymentStatus = 2;
        switch (payType) {
            case "wechat" :
                paymentStatus = wechatPayService.payWithAmount(tradeNumber, amount);
                break;
            case "ali" :
                paymentStatus = aliPayService.payWithAmount(tradeNumber, amount);
                break;
            case "creditcard" :
                paymentStatus = creditCardPayService.payWithAmount(tradeNumber, amount);
                break;
        }

        return paymentStatus;
    }
}
