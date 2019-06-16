package com.yofun.controller;

import com.yofun.model.Merchant;
import com.yofun.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/insertMerchant", method = RequestMethod.POST)
    public void insertMerchant(Merchant merchant) {
        merchantService.insertMerchant(merchant);
    }

    @RequestMapping(value = "/toInsertMerchant", method = RequestMethod.GET)
    public String toInsertMerchant() {
        return "merchantregister";
    }
}
