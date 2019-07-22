package com.yofun.controller;

import com.alibaba.fastjson.JSONObject;
import com.yofun.model.Order;
import com.yofun.service.AliPayService;
import com.yofun.service.CreditCardPayService;
import com.yofun.service.OrderService;
import com.yofun.service.WechatPayService;
import com.yofun.service.wechat.PayRequest;
import com.yofun.service.wechat.PayResponse;
import com.yofun.service.wechat.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class PaymentController {

    @Autowired
    private WechatPayService wechatPayService;

    @Autowired
    private AliPayService aliPayService;

    @Autowired
    private CreditCardPayService creditCardPayService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @RequestMapping(value = "/payWithAmount")
    public int payWithAmount(String payType, String tradeNumber, double amount) {

        int paymentStatus = 2;
        if ("wechat".equals(payType)) {
            paymentStatus = wechatPayService.payWithAmount(tradeNumber, amount);
        } else if ("ali".equals(payType)) {
            paymentStatus = aliPayService.payWithAmount(tradeNumber, amount);
        } else if ("creditcard".equals(payType)) {
            paymentStatus = creditCardPayService.payWithAmount(tradeNumber, amount);
        }

        return paymentStatus;
    }

    @GetMapping("/auth")
    public ModelAndView auth(@RequestParam("code") String code, @RequestParam("orderId") int orderId) {
        System.out.println("Get into auth with code : " + code);
        //https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb4e82a4010455147&redirect_uri=https://new-puma-90.localtunnel.me/auth?response_type=code&scope=snsapi_base#wechat_redirect
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxb4e82a4010455147&secret=4497f3457ba58540067d5bcf1a5248ff&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("response=" + response);

        JSONObject jsonObject = JSONObject.parseObject(response);
        String openId = jsonObject.getString("openid");

        WxPayServiceImpl wxPayService = new WxPayServiceImpl();
        PayRequest request = new PayRequest();
        request.setOpenid(openId);
        request.setOrderId(String.valueOf(orderId));
        request.setOrderName("wechat pay test");
        Order order = orderService.findOrderById(orderId);
        request.setOrderAmount(order.getPaymentAmout());
        PayResponse payResponse = wxPayService.pay(request);
        System.out.println(payResponse);

        Map<String, Object> map = new HashMap<>();
        map.put("payResponse", payResponse);
        map.put("returnUrl", "http://youfan.natapp1.cc/notify");
        return new ModelAndView("pay/create", map);
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
//        payService.notify(notifyData);
        WxPayServiceImpl wxPayServiceImpl = new WxPayServiceImpl();
        PayResponse payResponse = wxPayServiceImpl.asyncNotify(notifyData);
        if(payResponse != null && payResponse.getOrderId() != null){
            String orderId = payResponse.getOrderId();
            orderService.updateOrderById(Integer.valueOf(orderId),1,2);
        }
        // return result to wechat
        return new ModelAndView("pay/success");
    }
}
